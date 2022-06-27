FROM openjdk:11

ADD target/*.jar .

ENTRYPOINT ["java","-jar","gilded-rose-kata-0.0.1-SNAPSHOT.jar"]

