
📌 **Content**
```markdown
# Why Kafka Is Not Run in Local Kubernetes

Kafka is a stateful, resource-intensive system and is not well-suited
to plain Kubernetes deployments in local environments such as
Docker Desktop or Minikube.

Common issues include:
- CrashLoopBackOff
- Port and listener conflicts
- Storage and resource constraints

## Architectural Decision
- Kafka and Zookeeper are run via Docker Compose locally
- Application services run in Kubernetes
- This mirrors real-world development practices

In production, Kafka would be:
- A managed service
- Or deployed using an operator such as Strimzi
