# Project Setup Guide

This guide will help you set up and run the project on your local machine.

## Prerequisites

- [Git](https://git-scm.com/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Steps to Setup

### 1. Clone the Project

Clone the repository to your local machine using the following command:

```sh
git clone https://github.com/AdhithyanM/microservices-with-springboot.git
cd <your-repository-folder>
```

### 2. Open the Project in IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Click on `Open` or `Import Project`.
3. Select the cloned project directory.
4. Ensure that the project is imported as a Maven project:
    - IntelliJ should automatically detect the Maven modules. If not, right-click on the `pom.xml` file in the root directory and select `Add as Maven Project`.

### 3. Start Docker Containers

You need to start the necessary Docker containers for MongoDB, PostgreSQL, and Kafka. If you do not have Docker Compose files set up, you can find them using below links:
- [Mongo DB Docker Setup](https://github.com/AdhithyanM/mongodb-setup)
- [Postgres DB Docker Setup](https://github.com/AdhithyanM/postgres-setup)
- [Kafka Docker Setup](https://github.com/AdhithyanM/kafka-setup)

### 4. Run the Services

1. In IntelliJ IDEA, navigate to the `Maven` tool window.
2. For each service module (e.g., `api-gateway`, `discovery-server`, `order-service`, etc.):
    - Expand the module.
    - Expand the `Lifecycle` node.
    - Double-click on `install` to build the module.
    - After building, you can run the services by navigating to the main class (e.g., `ApiGatewayApplication`, `DiscoveryServerApplication`) and clicking the `Run` button.

### 5. Access the API Gateway

Once all services are running, you can access the API Gateway at:

```
http://localhost:8080
```

This should provide access to the endpoints exposed by the various microservices through the API Gateway.

## Additional References

- [MongoDB Docker Hub](https://hub.docker.com/_/mongo)
- [PostgreSQL Docker Hub](https://hub.docker.com/_/postgres)
- [Kafka Docker Hub](https://hub.docker.com/r/wurstmeister/kafka)
- [Docker Compose Documentation](https://docs.docker.com/compose/)

By following these steps, you should be able to set up and run the project successfully on your local machine.
