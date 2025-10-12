package com.windy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.windy.domains.Product;
import com.windy.repositories.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProductService(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProductService() {
        return productRepository.findAll();
    }
}
