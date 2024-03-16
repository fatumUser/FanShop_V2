package com.example.fanshopV2.controllers;

import com.example.fanshopV2.entitys.User;
import com.example.fanshopV2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("username", user.getUsername());
        return "profile.html";
    }

    @PostMapping("descProfile")
    public String profile(@AuthenticationPrincipal User user, String desc, Model model) {
       User user1 = userRepository.findByUsername(String.valueOf(user));
       user1.setDesc(desc);
       model.addAttribute("desc", user1.getDesc());
       return  "profile.html";
    }


}
