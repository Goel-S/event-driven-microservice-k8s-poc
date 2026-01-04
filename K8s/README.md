# Kubernetes Deployment

## Prerequisites
- Docker Desktop
- Kubernetes enabled
- Kafka running via Docker Compose

## Deploy Product Service
```bash
kubectl apply -f product-deployment.yaml

## Verify Deployment
kubectl get pods
kubectl get svc
kubectl logs deployment/product-service
