FROM izone/tomcat

# Default Environment
ARG DB_HOST=127.0.0.1:3306
ARG DB_NAME=insight
ARG DB_USER=user
ARG DB_PASSWORD=user

# Dynamic Environment
ENV DB_HOST=$DB_HOST \
  DB_NAME=$DB_NAME \
  DB_USER=$DB_USER \
  DB_PASSWORD=$DB_PASSWORD

VOLUME /tmp

EXPOSE 8080
ADD /target/demo-3-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
