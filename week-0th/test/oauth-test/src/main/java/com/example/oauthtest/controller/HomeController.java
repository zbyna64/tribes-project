package com.example.oauthtest.controller;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home(Model model, Authentication authentication) {

        model.addAttribute("user", authentication);
        return "home";
    }


    @GetMapping("/user")
    public Authentication user(Authentication authentication) {

        return authentication;
    }
}
