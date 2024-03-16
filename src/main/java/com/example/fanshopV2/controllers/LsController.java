package com.example.fanshopV2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LsController {

    @PostMapping("addLs")
    public String addLs(Model model) {
        return "message.html";
    }
}
