package com.windy.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.windy.domains.Product;

@Controller
public class ProductController {

    // site

    @GetMapping("/site/product/{id}")
    public String getProductById(@PathVariable("id") Long id, Model model) {
        return "/site/product/product-detail";
    }

    // admin
    @GetMapping("/admin/product")
    public String getAllProductAdmin(Model model) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(
                1L,
                "iPhone 15 Pro Max",
                1499.99,
                "iphone15promax.jpg",
                "Flagship smartphone from Apple with A17 Pro chip, titanium frame, and 120Hz ProMotion display.",
                "Powerful and elegant premium smartphone.",
                50L,
                10L,
                "Apple",
                "High-end users"));
        model.addAttribute("products", products);
        return "/admins/products/list-product";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductForm() {
        return "/admins/products/add-product";
    }
}
