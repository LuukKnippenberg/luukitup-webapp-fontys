# luukitup-webapp-fontys Backend
This project was made for Fontys ICT Semester 3.
It's a Quarkus Hibernate based project.


# luuk-it-up project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and Deployment Preparation

Prepare a new Docker Image
```shell script
./mvnw clean package -Dquarkus.container-image.build=true -Dquarkus.container-image.push=true -Dquarkus.container-image.name=luukitup -Dquarkus.container-image.group=luukitup -Dquarkus.container-image.tag=latest
```

## Ubuntu Deployment
Deploy the new Docker Image to server

```ubuntu script
docker stop luukitup
```

```ubuntu script
docker pull luukitup/luukitup:latest
```

```ubuntu script
docker run -d -p 8002:3000 --name luukitup --rm luukitup/luukitup:latest
```
