# NBA Database by Hange Chen
## Description 
This is a sample project for [NBA database](https://github.com/Hange1995/NBA).
You can get the 
## Assumption

## Approach
* Project Business Rules:
1. Object: Player,Team,Position,PlayerData, User, Role
2. Relationships:
    1.One team can have many players.
    2.One position can have several players.
    3.One player can have few player's data from different seasons. However, one player can only have one current season data.
    4.One user can have multiple roles.
* Project Approach:

1. Create User, Role, Player, Team, Position, PlayerData.
2. Used Hibernate to do the database schema migration.
3. Used JDBC to connect project with Postgres.
4. Configured Spring Security for Authentication.
5. Created repository, service and did test.
6. Created Controllers and Restful APIs.
7. Did mock test for AWS S3 Storage service.
8. Integrated third-party application AWS SQS and did Mock test.
 
    

## Build Project
1. Clone the project.
```
git clone https://github.com/Hange1995/NBA.git
```
2. Install Docker if necessary.
3. Use command window to spin up the PostgreSql database server using Postgres docker image.
```
docker pull postgres

docker run --name ${PostgresContainerName} -e POSTGRES_USER=${username} -e POSTGRES_PASSWORD=${password} -e POSTGRES_DB=${databaseName} -p ${hostport}:${containerport} -d postgres
```
4. Create Unit database on PGAdmin for unit testing
```

```
5. Environment properties configuration
```
location:./src/main/resources/META-INF/env
   
Template:
database.driverName=${driverName}
database.url=${url}
database.port=${port}
database.name=${name}
database.username=${username}
database.password=${password}
   
mvn compile -Dspring.profiles.active=${env}
```
6. Schema Flyway migration for creating tables in database
```
mvn compile flyway:migrate -P unit -Ddb_username=${username} -Ddb_url=localhost:${containerport}/${databasename} -Ddb_password=${password} 

```
## Compile

## Test****
## Run Migration
## Package
## API guildline
## ScreenShoot DEMO




