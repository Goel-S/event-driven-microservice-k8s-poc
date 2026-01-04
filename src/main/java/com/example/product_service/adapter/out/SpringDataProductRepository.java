package com.example.product_service.adapter.out;

import com.example.product_service.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository
        extends JpaRepository<Product, Long> {
}