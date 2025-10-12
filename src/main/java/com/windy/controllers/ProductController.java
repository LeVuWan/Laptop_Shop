package com.windy.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.windy.domains.Product;
import com.windy.services.ProductService;
import com.windy.services.UploadService;

import jakarta.validation.Valid;

@Controller
public class ProductController {

    private final UploadService uploadService;
    private final ProductService productService;

    public ProductController(UploadService service, ProductService productService) {
        this.uploadService = service;
        this.productService = productService;
    }

    @GetMapping("/site/product/{id}")
    public String getProductById(@PathVariable("id") Long id, Model model) {
        return "/site/product/product-detail";
    }

    // admin
    @GetMapping("/admin/product")
    public String getAllProductAdmin(Model model) {
        List<Product> products = productService.getAllProductService();
        model.addAttribute("products", products);
        return "admins/products/list-product";
    }

    @GetMapping("/admin/product/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("factories", List.of("Apple", "Samsung", "Xiaomi", "Oppo", "Vivo", "Asus"));
        model.addAttribute("targets", List.of("Student", "Office worker", "Gamer", "Photographer", "Business user"));
        return "admins/products/add-product";
    }

    @PostMapping("/admin/product/create")
    public String createProduct(
            @Valid @ModelAttribute("product") Product product,
            BindingResult bindingResult,
            @RequestParam("file") MultipartFile file,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("factories", List.of("Apple", "Samsung", "Xiaomi", "Oppo", "Vivo", "Asus"));
            model.addAttribute("targets",
                    List.of("Student", "Office worker", "Gamer", "Photographer", "Business user"));
            return "admins/products/add-product";
        }

        String imgProductUrl = uploadService.uploadImage(file, "products");

        if (imgProductUrl != null) {
            product.setImage(imgProductUrl);
        } else {
            product.setImage("");
        }
        productService.saveProductService(product);
        return "redirect:/admin/product";
    }
}
