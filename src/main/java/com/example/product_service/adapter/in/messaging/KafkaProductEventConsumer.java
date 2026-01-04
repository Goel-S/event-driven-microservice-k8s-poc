package com.example.product_service.adapter.in.messaging;

import com.example.product_service.adapter.out.messaging.ProductCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class KafkaProductEventConsumer {
    private static final Logger log =
            LoggerFactory.getLogger(KafkaProductEventConsumer.class);


    @KafkaListener(
            topics = "product.created",
            groupId = "product-service-group"
    )
    public void consume(ProductCreatedEvent event) {

        // Architect note:
        // This is where downstream processing will happen later
        System.out.println(
                "[Kafka Consumer] Product Created Event Received -> " +
                        "ID=" + event.getProductId() +
                        ", Name=" + event.getName() +
                        ", Price=" + event.getPrice()
        );
        log.info("Consumed ProductCreatedEvent: {}", event.getName());
    }
}