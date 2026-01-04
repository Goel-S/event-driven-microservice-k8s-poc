package com.example.product_service.adapter.out.messaging;

import com.example.product_service.domain.Product;
import com.example.product_service.adapter.out.messaging.ProductEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProductEventPublisher implements ProductEventPublisher {

    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    public KafkaProductEventPublisher(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishProductCreated(Product product) {
        ProductCreatedEvent event = new ProductCreatedEvent(
                product.getId(),
                product.getName(),
                product.getPrice()
        );

        kafkaTemplate.send("product.created", event);
    }
}
