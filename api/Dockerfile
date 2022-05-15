FROM openjdk:11

COPY ./api/ /usr/src/myapp

WORKDIR /usr/src/myapp

EXPOSE 8090/tcp

RUN ./gradlew init

CMD ["./gradlew", "bootRun"]