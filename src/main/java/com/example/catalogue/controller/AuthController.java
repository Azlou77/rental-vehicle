package com.example.catalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.catalogue.entity.Role;
import com.example.catalogue.entity.User;
import com.example.catalogue.repository.UserRepository;
import com.example.catalogue.service.UserService;


@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // login.html
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // register.html
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        user.setRole(Role.CLIENT);
        userService.addUser(user); // Utilisation du service
        return "redirect:/auth/login";
    }
}