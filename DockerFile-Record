FROM openjdk:11
EXPOSE 8040
ADD RecordService/target/recordService.jar recordService.jar
ENTRYPOINT ["java", "-jar", "recordService.jar"]