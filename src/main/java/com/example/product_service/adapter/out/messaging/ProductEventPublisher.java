package com.example.product_service.adapter.out.messaging;

import com.example.product_service.domain.Product;

public interface ProductEventPublisher {
    void publishProductCreated(Product product);
}
