#Stage 1
# initialize build and set base image for first stage
FROM maven:3.6.3-adoptopenjdk-15 as stage1
# speed up Maven JVM a bit
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
# set working directory
WORKDIR /opt/gestion-experiences
# copy just pom.xml
COPY pom.xml .
# go-offline using the pom.xml
RUN mvn dependency:go-offline
# copy your other files
COPY ./src ./src
# compile the source code and package it in a jar file
RUN mvn clean install -D maven.test.skip=true
#Stage 2
# set base image for second stage
FROM adoptopenjdk/openjdk15
# set deployment directory
WORKDIR /opt/gestion-experiences
# copy over the built artifact from the maven image
COPY --from=stage1 /opt/gestion-experiences/target/gestion-experiences-0.0.1-SNAPSHOT.jar /opt/gestion-experiences

# Expose the port on which the application will run
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "gestion-employes-0.0.1-SNAPSHOT.jar"]