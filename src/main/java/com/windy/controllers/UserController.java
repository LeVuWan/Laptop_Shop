package com.windy.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.windy.domains.Role;
import com.windy.domains.User;
import com.windy.services.RoleService;
import com.windy.services.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping("/create")
    public String createUserController(@ModelAttribute User user) {
        System.out.println("Check user: " + user.toString());
        userService.saveUserServie(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/create")
    public String getFormCreateController(Model model) {
        List<Role> roles = roleService.getAllRolesService();
        model.addAttribute("roles", roles);
        return "admins/users/add-new-user";
    }

    @GetMapping("")
    public String getAllUserController(Model model) {
        List<User> users = userService.gettAllUserService();
        model.addAttribute("users", users);
        return "admins/users/list-user";
    }

    @GetMapping("{id}")
    public String getUserByIdController(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserByIdService(id);
        model.addAttribute("user", user);
        return "admins/users/user-detail";
    }

    @GetMapping("edit/{id}")
    public String getFormEditUserController(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserByIdService(id);
        model.addAttribute("user", user);
        return "admins/users/edit-user";
    }

    @PostMapping("edit")
    public String updateUserController(@ModelAttribute("user") User user) {
        userService.saveUserServie(user);
        return "redirect:/admin/user";
    }

    @GetMapping("delete/{id}")
    public String getFormDeleteUserController(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "admins/users/delete-user";
    }

    @PostMapping("delete/{id}")
    public String deleteUserController(@PathVariable("id") Long id) {
        userService.deleteUserService(id);
        return "redirect:/admin/user";
    }
}
