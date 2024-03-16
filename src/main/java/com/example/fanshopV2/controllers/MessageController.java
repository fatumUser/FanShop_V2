package com.example.fanshopV2.controllers;

import com.example.fanshopV2.entitys.Message;
import com.example.fanshopV2.entitys.User;
import com.example.fanshopV2.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/message")
    public String message(Model model) {
        Iterable<Message> messages = messageRepository.findAll();
        model.addAttribute("messages", messages);
        return "message.html";
    }

    @PostMapping("addMessage")
    public String addMessage(@RequestParam String text, @RequestParam String tag,
                             @AuthenticationPrincipal User user, Model model
    ) {
        Message message = new Message(text, tag, user);
        message.addNameAuthor();
        messageRepository.save(message);
        Iterable<Message> messages = messageRepository.findAll();
        model.addAttribute("messages", messages);
        return "message.html";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Model model) {
        Iterable<Message> messages;
        if(filter != null && !filter.isEmpty()) {
            messages = messageRepository.findByTag(filter);
        }
        else {
            messages = messageRepository.findAll();
        }
        model.addAttribute("messages", messages);
        return "basket.html";
    }

}
