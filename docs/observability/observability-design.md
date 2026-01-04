# Observability Design

## Logging
- SLF4J with Logback
- Structured logs with trace and span IDs
- Logs written to stdout for container environments

## Metrics
- Micrometer integrated with Spring Boot
- JVM, HTTP, and Kafka metrics exposed
- Prometheus-compatible `/actuator/prometheus` endpoint

## Tracing
- Micrometer Tracing with Brave
- Trace context propagated across REST calls and Kafka events

## Future Enhancements
- Grafana dashboards
- Alerting via Prometheus Alertmanager
- Centralized log aggregation (ELK / Loki)
