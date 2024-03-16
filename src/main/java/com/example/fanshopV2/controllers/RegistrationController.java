package com.example.fanshopV2.controllers;

import com.example.fanshopV2.entitys.User;
import com.example.fanshopV2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/registration")
    public String registration() {
        return "registration.html";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String username, @RequestParam String password, Model model) {
        User userIF;
        userIF = userRepository.findByUsername(username);
        if (userIF != null) {
            System.out.println("Этот пользователь уже существует");
            String message = "Пользователь с именем '" + username + "', уже существует :(";
            model.addAttribute("message", message);
            return "registration.html";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setValue("none");
        userRepository.save(user);
        return "redirect:/login";
    }
}












/*
        Student student1 = new Student();
        student1.setName("Dima");
        student1.setAge(15);

        Student student2 = new Student();
        student2.setName("Ivan");
        student2.setAge(18);

        Student student3 = new Student();
        student3.setName("Roma");
        student3.setAge(15);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        Director director = new Director();
        director.setName("Valentina");
        director.setAge(56);
        director.setMany(45000);

        School school = new School();
        school.setTitle("School 5");
        school.setStudents(students);
        school.setDirector(director);

        directorRepo.save(director);
        studentRepo.save(student1);
        studentRepo.save(student2);
        studentRepo.save(student3);
        schoolRepo.save(school); */
