FROM openjdk:11
ADD LevelService/target/levelService.jar levelService.jar
ADD RecordService/target/recordService.jar recordService.jar
ADD UserService/target/userService.jar userService.jar
RUN java -jar levelService.jar & java -jar recordService.jar & java -jar userService.jar