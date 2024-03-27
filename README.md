# Todo App (Spring Boot + PostgreSQL + Kubernetes)

This project is a Todo application built with Spring Boot, using PostgreSQL as the database, and facilitates deployment on Kubernetes with Minikube and Skaffold.

## Prerequisites

- [Minikube](https://minikube.sigs.k8s.io/docs/start/) installed
- [Skaffold](https://skaffold.dev/docs/install/) installed
- [kubectl](https://kubernetes.io/ja/docs/tasks/tools/install-kubectl/) installed

## Running the Application

1. Clone the repository.
   ```bash
   git clone git@github.com:Rujuu-prog/todo-k8s-practice.git
   cd todo-k8s-practice
   ```
2. Set up Secrets.
   ```bash
   cp k8s/secret.yaml.example k8s/secret.yaml
   ```
   Edit secret.yaml to set your actual values
3. Start Minikube.
   ```bash
   minikube start
   ```
4. Start Skaffold.
   ```bash
   skaffold dev
   ```
5. Start the application.
   ```bash
   minikube service todo-deployment-app
   ```

## Usage

### Minikube Dashboard

To access the Minikube Dashboard, which provides a web-based Kubernetes user interface, you can use the following command:

```bash
minikube dashboard
```
