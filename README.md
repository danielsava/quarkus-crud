
# Quarkus 3

  - Quarkus 3 is based on Jakarta EE 10 (jakarta.*)

  - obs: Quarkus 2 was based on Jakarta EE 8. (javax.*)

# Intellij

### Project Structure

 <img src="img.png" width="600">


# Maven Skip Tests

 - clean install -DskipTests -Dquarkus.analytics.disabled=true


# Banco de Dados: Docker

    - docker run --rm=true --name postgres-quarkus-hibernate -e POSTGRES_USER=hibernate \
           -e POSTGRES_PASSWORD=hibernate -e POSTGRES_DB=hibernate_db \
           -p 5432:5432 postgres:14.1

    - docker run -d --name mariadb -e MARIADB_ROOT_PASSWORD=123456 -p 3306:3306 mariadb     



# JKube
 
  - https://eclipse.dev/jkube/ 
  - https://www.baeldung.com/ops/eclipse-jkube
  - https://medium.com/swlh/deploy-quarkus-todo-list-app-to-kubernetes-using-eclipse-jkube-c774ef6b68f0

  - https://rohaan.medium.com/deploying-java-applications-onto-kubernetes-using-eclipse-jkube-c2ad83a7d98a
  - https://medium.com/swlh/deploy-quarkus-todo-list-app-to-kubernetes-using-eclipse-jkube-c774ef6b68f0 



# Json (Jackson)


In Quarkus, the default Jackson ObjectMapper obtained via CDI (and consumed by the Quarkus extensions) 
is configured to ignore unknown properties(by disabling the DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES feature).

Furthermore, the ObjectMapper is configured to **format dates and time in ISO-8601** (by disabling the 
SerializationFeature.WRITE_DATES_AS_TIMESTAMPS feature).
  - 2022-09-27 18:00:00.000 (YYYY-MM-DD)

The default behaviour of Jackson can be restored by setting quarkus.jackson.write-dates-as-timestamps=true in your
application.properties. If you want to change the format for a single field, you can use the @JsonFormat annotation



# quarkus-crud

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-crud-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
