# Event-Driven Microservice on Kubernetes – POC

## Overview
This Proof of Concept demonstrates an **event-driven microservice** built using **Spring Boot**, **Kafka**, **Docker**, and **Kubernetes**, following **Clean / Hexagonal Architecture** principles.

The objective is to showcase **architect-level design decisions**, not just application code.

---

## Architecture Style
- Clean Architecture (Domain, Application, Adapter layers)
- Hexagonal / Ports & Adapters pattern
- Event-driven communication using Kafka
- REST APIs for synchronous interactions

---

## Event Flow
1. Client calls `POST /products`
2. Product Service persists product
3. `ProductCreatedEvent` is published to Kafka
4. Kafka consumers process the event independently

This enables loose coupling and scalability.

---

## Local Development Strategy

Due to known limitations of running Kafka inside local Kubernetes clusters, the following hybrid approach is used:

| Component | Runtime |
|---------|--------|
| Kafka + Zookeeper | Docker Compose |
| Product Service | Kubernetes |
| Communication | `host.docker.internal:9092` |

This mirrors real-world setups where infrastructure components are external or managed.

---

## Observability

### Logging
- Structured logging using SLF4J
- Logs written to stdout (Kubernetes-friendly)
- Trace and span IDs included in log context

### Metrics
- Spring Boot Actuator enabled
- Micrometer metrics exposed
- Prometheus-compatible endpoint

Endpoints:
- `/actuator/health`
- `/actuator/metrics`
- `/actuator/prometheus`

### Tracing
- Micrometer Tracing (Brave)
- Context propagated across REST and Kafka

---

## Kubernetes Deployment
- Product Service deployed as a `Deployment`
- Exposed via `NodePort`
- Kafka treated as an external dependency

Deployment manifests are available under the `k8s/` directory.

---

## Production Considerations
- Kafka would be a managed service (MSK / Confluent / Aiven)
- Prometheus + Grafana for monitoring
- Jaeger / Tempo for distributed tracing
- CI/CD pipeline for automated deployments

---

## License
MIT License
