FROM openjdk:11
COPY target/mcs.user.jar user-app.jar

ENTRYPOINT ["java","-jar","user-app.jar"]

