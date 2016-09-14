FROM java:8

MAINTAINER yangliao

VOLUME /tmp

ADD spring-boot-mybatis.jar app.jar
RUN bash -c 'touch /app.jar'

EXPOSE 80

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]