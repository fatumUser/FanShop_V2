package com.example.fanshopV2.controllers.StripeController;

import com.example.fanshopV2.entitys.User;
import com.example.fanshopV2.entitys.stripeEntitys.Request;
import com.example.fanshopV2.repositories.UserRepository;
import com.example.fanshopV2.repositories.stripeRepo.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    private RequestRepo requestRepo;
    @Autowired
    private UserRepository userRepository;

    @Value("${stripe.api.publicKey}")
    private String stripePublicKey;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("request", new Request());
        return "stripePayments/index.html";
    }

    @PostMapping("/")
    public String showCard(@ModelAttribute Request request,
                           @AuthenticationPrincipal User user,
                           BindingResult bindingResult,
                           Model model){
        if (bindingResult.hasErrors()){
            return "stripePayments/index";
        }
        Request request1 = request;
        User user1 = userRepository.findByUsername(user.getUsername());
        request1.setAmount(user1.getBasketPrise());
        requestRepo.save(request1);
        model.addAttribute("publicKey", stripePublicKey);
        model.addAttribute("amount", request1.getAmount());
        model.addAttribute("email", request1.getEmail());
        model.addAttribute("productName", request1.getProductName());
        return "stripePayments/checkout.html";
    }

}
