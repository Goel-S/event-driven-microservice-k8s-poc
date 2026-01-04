package com.example.product_service.application;
import com.example.product_service.domain.Product;
public interface CreateProductUseCase {
    Product create(String name, double price);
}
