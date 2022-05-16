# Area Service

## Description

Community Health Service Area (CHSA) locator service helps users know their CHSA and its code based on the geographical location. The user has to enter relevant latitude and longitude on the screen to fetch the details

## Getting Started

### Pre-Requisites

- Docker/Docker-Compose
- MySQL Workbench (Optional)

### Unit Tests

#### UI 

- Navigate to folder `./ui`
- Run the command `npm run test` to run the unit tests

#### API

- Navigate to folder `./api`
- Make sure mysql instance is up and running as tests use it
- Run the command `./gradlew test` to run the unit tests

### Installation

- Run `git clone https://github.com/NithinKuruba/areaservice.git` to save the repository to your workspace

- Run `docker-compose up` from the root directory
  - Optionally use flag `-d` to run the docker compose in the background

- Access the application at `http://localhost:3000`

- Please allow upto ~2 mins for the API to be ready for accepting requests

### Connecting to database to view the request count

- Run `docker exec -it mysql bash` from your terminal to launch an interactive shell
- Run `mysql -u admin -p` to connect to mysql instance
- Enter password `admin` upon the prompt
- Run `USE healthservice` to select to the database
- Run sql query `select count(*) from request;` to fetch the number of requests made to the areaservice API
- Run `exit` twice to disconnect from mysql and to exit the interactive shell

### Un-installation

- Run `docker-compose down` from the root directory

## License

This project is licensed under the [Apache License, Version 2.0](https://github.com/NithinKuruba/areaservice/blob/main/LICENSE)