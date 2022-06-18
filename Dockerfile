FROM openjdk:11
EXPOSE 8080
EXPOSE 8060
EXPOSE 8040
ADD LevelService/target/levelService.jar levelService.jar
ADD UserService/target/userService.jar userService.jar
ADD RecordService/target/recordService.jar recordService.jar
ENTRYPOINT ["java", "-jar", "levelService.jar"]
ENTRYPOINT ["java", "-jar", "recordService.jar"]
ENTRYPOINT ["java", "-jar", "userService.jar"]
