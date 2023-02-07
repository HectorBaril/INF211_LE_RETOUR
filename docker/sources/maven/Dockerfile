FROM alpine:latest

RUN apk update
RUN apk add --no-cache bash
RUN apk add --no-cache openjdk17
RUN apk add --no-cache maven

RUN mkdir /app
WORKDIR /app/

ENTRYPOINT ["mvn", "clean", "install" ] 
