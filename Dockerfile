FROM openjdk:8
EXPOSE 8082
ADD target/weather-api-docker-jenkins-integration-sample.jar  weather-api-docker-jenkins-integration-sample.jar
ENTRYPOINT ["java","-jar","/weather-api-docker-jenkins-integration-sample.jar"]