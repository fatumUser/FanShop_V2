package com.example.fanshopV2.controllers;

import com.example.fanshopV2.entitys.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user.getUsername());
        model.addAttribute("username", user.getUsername());
        return "main.html";
    }

}
