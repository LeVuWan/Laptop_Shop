package com.windy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.windy.domains.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
