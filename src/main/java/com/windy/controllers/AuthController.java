package com.windy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.windy.dto.RegisterDTO;
import com.windy.services.AuthService;

@Controller
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        model.addAttribute("registerDTO", new RegisterDTO());
        return "site/auth/register";
    }

    @PostMapping("/register")
    public String registerController(@ModelAttribute("registerDTO") RegisterDTO registerDTO) {
        authService.registerService(registerDTO);
        return "redirect:login";
    }

    @GetMapping("/login")
    public String getFormLogin(Model model) {
        return "site/auth/login";
    }
}
