package com.windy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HompageController {

    @GetMapping("/")
    public String getHomePage() {
        return "site/home/home-page";
    }
}
