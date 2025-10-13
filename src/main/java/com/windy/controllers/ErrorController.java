package com.windy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/errors/403")
    public String error403() {
        return "errors/403";
    }
}
