package com.example.catalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.catalogue.entity.User;
import com.example.catalogue.repository.UserRepository;


@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Affiche login.html
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User()); // Pour formulaire d’inscription
        return "register"; // Affiche register.html
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        // ⚠️ Ajoute ici encodage du mot de passe si tu utilises Spring Security
        userRepository.save(user);
        return "redirect:/auth/login";
    }
}