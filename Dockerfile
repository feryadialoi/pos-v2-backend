# use the openjdk 11 as the base image
FROM openjdk:11

# copy the app files from host machine to image filesystem
COPY target/pos-backend-0.0.1-SNAPSHOT.jar /app/application.jar

# run the application
CMD ["java", "-jar", "/app/application.jar"]