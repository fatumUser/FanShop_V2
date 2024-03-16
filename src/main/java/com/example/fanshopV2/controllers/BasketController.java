package com.example.fanshopV2.controllers;


import com.example.fanshopV2.entitys.User;
import com.example.fanshopV2.repositories.ProductRepository;
import com.example.fanshopV2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasketController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/basket")
    public String basket(Model model, @AuthenticationPrincipal User user) {
        User user1 = userRepository.findByUsername(user.getUsername());
        model.addAttribute("products", user1.getProducts());
        model.addAttribute("user", user.getUsername());
        User user2 = userRepository.findByUsername(user.getUsername());
        model.addAttribute("basketPrise", user2.getBasketPrise());
        return "basket.html";
    }

}
