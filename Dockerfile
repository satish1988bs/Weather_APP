FROM openjdk:8
EXPOSE 8080
ADD target/com.sbs.test-0.0.1-SNAPSHOT com.sbs.test-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/com.sbs.test-0.0.1-SNAPSHOT.jar"]