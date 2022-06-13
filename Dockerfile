FROM openjdk:11

EXPOSE 8080

RUN mkdir ./app

COPY ./build/libs/core-1.jar ./app

CMD java -jar ./app/core-1.jar
