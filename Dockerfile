# Define a Base Docker Image (This can also be another docker image)
FROM openjdk:17
#Create a maintainer, It can be your name
LABEL maintainer="warith.com"
#Copy or add the generated jar file into the docker image
#The docker image name is the last one "springboot-security-docker.jar"
ADD target/SpringBootSecurity-0.0.1-SNAPSHOT.jar springboot-security-docker.jar
#Create an Entry point i.e. Tell docker how the application is going to run or execute inside the docker cointainer
ENTRYPOINT ["java", "-jar", "springboot-security-docker.jar"]