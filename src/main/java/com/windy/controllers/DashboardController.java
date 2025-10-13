package com.windy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/admin")
    public String getDashboard() {
        System.out.println("Run here");
        return "/admins/dashboards/show";
    }
}
