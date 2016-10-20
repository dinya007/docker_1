FROM localhost:5000/alpine-oraclejdk8:latest
VOLUME /tmp
ADD build/libs/docker_1-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]