# kafka-quarkus

Quarkus provides support for Apache Kafka through SmallRye Reactive Messaging framework. Based on Eclipse MicroProfile Reactive Messaging specification 2.0, it proposes a flexible programming model bridging CDI and event-driven.

## Starting Kafka

Spin up a local Kafka cluster with the docker-compose file located in the {project-folder}/kafka folder

```shell script
docker-compose up -d
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

With Love :)
