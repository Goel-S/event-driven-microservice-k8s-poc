package com.example.product_service.application;

import com.example.product_service.domain.Product;

import java.util.Optional;

public interface GetProductUseCase {
    Optional<Product> getById(Long id);
}
