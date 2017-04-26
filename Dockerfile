FROM localhost:5000/openjdk:alpine
VOLUME /tmp
ADD build/libs/docker_1-1.0-SNAPSHOT.jar app.jar
#RUN sh -c 'touch /app.jar'
#RUN chmod 755 /docker-entrypoint.sh
ENTRYPOINT exec java $JAVA_OPTS  -jar /app.jar
#ENTRYPOINT ["exec", "java","$JAVA_OPTS", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#CMD ["java","$JAVA_OPTS","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#ENTRYPOINT ["java","$JAVA_OPTS","-jar","/app.jar"]
#ENTRYPOINT ["java","-jar","/app.jar"]
#CMD ["java","$JAVA_OPTS","-jar","/app.jar"]
