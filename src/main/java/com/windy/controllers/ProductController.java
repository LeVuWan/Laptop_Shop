package com.windy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    //site

    @GetMapping("/site/product/{id}")
    public String getProductById(@PathVariable("id") Long id, Model model) {
        return "/site/product/product-detail";
    }

    //controller

}
