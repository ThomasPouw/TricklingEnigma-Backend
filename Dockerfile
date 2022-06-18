FROM openjdk:11
EXPOSE 8080
EXPOSE 8060
EXPOSE 8040
ADD LevelService/target/levelService.jar levelService.jar
ADD RecordService/target/recordService.jar recordService.jar
ADD UserService/target/userService.jar userService.jar
ENTRYPOINT ["java", "-jar", "levelService.jar", "&", "java", "-jar", "recordService.jar", "&","java", "-jar", "userService.jar"]
