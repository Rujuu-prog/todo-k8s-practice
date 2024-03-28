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
5. Allow external access to the backend application.
   This will open your default browser and navigate to the backend service. It enables you to interact with the backend API of the Todo application.
   ```bash
   minikube service todo-deployment-app
   ```
6. Allow external access to the frontend application.
   This will open your default browser and navigate to the frontend service. It enables you to interact with the frontend of the Todo application.
   ```bash
   minikube service todo-frontend
   ```

## Usage

### Minikube Dashboard

To access the Minikube Dashboard, which provides a web-based Kubernetes user interface, you can use the following command:

```bash
minikube dashboard
```
