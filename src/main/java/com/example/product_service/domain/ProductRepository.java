package com.example.product_service.domain;

import java.util.*;
public interface ProductRepository {
    Product save(Product product);

    Optional<Product> findById(Long id);
}
