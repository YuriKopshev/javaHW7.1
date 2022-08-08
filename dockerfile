FROM openjdk:11
EXPOSE 8081
ADD build/libs/conditionalApp-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","app.jar"]