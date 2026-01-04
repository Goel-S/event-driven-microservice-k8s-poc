package com.example.product_service.application;

import com.example.product_service.domain.Product;
import com.example.product_service.domain.ProductRepository;
import com.example.product_service.adapter.out.messaging.ProductEventPublisher;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements CreateProductUseCase, GetProductUseCase {

    private final ProductRepository repository;
    private final ProductEventPublisher eventPublisher; // PORT

    public ProductService(ProductRepository repository,
                          ProductEventPublisher eventPublisher
                          ) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Product create(String name, double price) {
        Product product = new Product(null, name, price);
        Product savedProduct = repository.save(product);

        // 🔔 Publish domain event (Kafka will be adapter)
        eventPublisher.publishProductCreated(savedProduct);

        return savedProduct;

        }

    @Override
    public Optional<Product> getById(Long id) {
        return repository.findById(id);
    }
}