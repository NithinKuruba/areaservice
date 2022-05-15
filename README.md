# Area Service

## Description

Community Health Service Area (CHSA) locator service helps users know their CHSA and its code based on the geographical location. The user has to enter relevant latitude and longitude on the screen to fetch the details. 

## Getting Started

### Pre-Requisites

- Docker/Docker-Compose
- MySQL Workbench (Optional)
- NodeJS
- Java

### Installing

- Run `git clone https://github.com/NithinKuruba/areaservice.git` to save the repository to your workspace

- Run `docker-compose up` from the root directory
  - Optionally use flag `-d` to run the docker compose in the background

- Access the application at `http://localhost:3000`

### Un-installing

- Run `docker-compose down` from the root directory

## Troubleshooting

### Connecting to database to view the request count

- Run `docker exec -it mysql sh` from your terminal to launch an interactive shell
- Run `mysql -u admin -p` to connect to mysql instance
- Enter password upon the prompt
- Run `USE healthservice` to select to the database
- Run sql `SELECT COUNT(*) FROM REQUEST;` to fetch the number of requests made to the areaservice API
- Run `exit` twice to disconnect from mysql and exit the interactive shell

## License

This project is licensed under the [Apache License, Version 2.0](https://github.com/NithinKuruba/areaservice/blob/main/LICENSE).