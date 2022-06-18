FROM openjdk:11
EXPOSE 8040
ADD target/recordService.jar recordService.jar
ENTRYPOINT ["java", "-jar", "recordService.jar"]