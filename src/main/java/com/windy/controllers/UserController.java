package com.windy.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.windy.domains.User;
import com.windy.services.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("create")
    public String getCreateUserForm() {
        return "add-new-user";
    }

    @PostMapping("/create")
    public String createUserController(@ModelAttribute User user) {
        userService.saveUserServie(user);
        return "redirect:/admin/user";
    }

    @GetMapping("")
    public String getAllUserController(Model model) {
        List<User> users = userService.gettAllUserService();
        for (User user : users) {
            System.out.println(user.toString());
        }
        model.addAttribute("users", users);
        return "list-user";
    }
}
