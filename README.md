# Product Service – Clean Architecture POC

## Overview
This repository demonstrates a **Java Spring Boot Product Service** built using **Clean / Hexagonal Architecture (Ports & Adapters)**.
It is designed as an **architect-level POC** to showcase:
- Clear separation of concerns
- NFR-driven design
- Event-driven integration (Kafka)
- Containerization and Kubernetes deployment readiness

## Architecture
- **Domain**: Pure business logic (Product, ProductRepository)
- **Application**: Use cases (CreateProductUseCase, GetProductUseCase)
- **Adapters**
  - Inbound: REST Controllers
  - Outbound: JPA Repository, Kafka Producer

## Tech Stack
- Java 17+
- Spring Boot
- Spring Data JPA
- Kafka
- Docker
- Kubernetes (YAML manifests)
- H2 / PostgreSQL (configurable)

## Run Locally
```bash
mvn clean spring-boot:run
```

## Docker
```bash
docker build -t product-service .
docker run -p 8080:8080 product-service
```

## Kafka (Local / K8s)
Kafka is used to publish `ProductCreatedEvent` asynchronously.

## API
- POST /products
- GET /products/{id}

## Non-Functional Requirements (NFRs)
- Low latency (<150ms P95)
- Horizontal scalability
- Eventual consistency for downstream consumers
- Observability-ready (logs + metrics hooks)

## Why Clean Architecture?
- Framework independence
- Testability
- Long-term maintainability
- Easy replacement of adapters (DB, Messaging, APIs)

## Author
Shivendra Goel
