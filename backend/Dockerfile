FROM openjdk:11

COPY ./backend/ /usr/src/myapp

WORKDIR /usr/src/myapp

EXPOSE 8090/tcp

RUN ls -lrta

RUN ./gradlew init

CMD ["./gradlew", "bootRun"]