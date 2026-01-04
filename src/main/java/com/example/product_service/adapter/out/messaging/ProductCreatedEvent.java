package com.example.product_service.adapter.out.messaging;

import java.io.Serializable;

public class ProductCreatedEvent implements Serializable {

    private Long productId;
    private String name;
    private Double price;

    // ✅ Required for Kafka deserialization
    public ProductCreatedEvent() {
    }

    public ProductCreatedEvent(Long productId, String name, Double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}