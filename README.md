# NBA Database by Hange Chen
## Description 
This is a sample project for [NBA database](https://github.com/Hange1995/NBA).
## Assumption
1. It's will be a web that provide you all the info about NBA.
2. The User need to sign up before access any data.
3. User can get all the player's info such as the current season data, all history season data, team info.
## Approach
* Project Business Rules:
1. Object: Player,Team,Position,PlayerData, User, Role
2. Relationships:
    1. One team can have many players.
    2. One position can have several players.
    3. One player can have few player's data from different seasons. However, one player can only have one current season data.
    4. One user can have multiple roles.
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
create database basketballDB_Demo_unit;
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

## Test
- Package and install the folder before unit test 
```
mvn clean compile install -DskipTests=true
```
-Run the test with the command. All the Test are done using JUnit and Mockito
```
mvn compile test -Dspring.profiles.active=${unit} -Daws.region=${region} -Ddb_url=${localhost:5432/pigge_unit} -Ddb.username=${username} -Ddb.password=${password} 
```

## Packaging
```
mvn clean compile package -DskipTests=true
```
## API guideline and Reference DEMO
- You need to sign up for authority to get access.<br />
Make a get request in this address to create a new account.<br />
     
```
GET - http://localhost:8080/auth/signUp
```
Put the request body.
```
{
    "name": "UserForTest",
    "email": "UserForTest@gmail.com",
    "password": "123456789"
}
``` 
Then you can get the response like:
```
{
    "name": "UserForTest",
    "firstName": null,
    "lastName": null,
    "email": "UserForTest@gmail.com",
    "activeStatus": true
}
```
DEMO screen shoot:
![Image of signUp](https://github.com/Hange1995/NBA/blob/master/READMESnapShoot/userSignUp.png?raw=true)
- You need to login.<br />
Make a post request in this address.
```
POST - http://localhost:8080/auth
```
Put the request body.（ You can chose login with username or email)
```
{
    "email": "UserForTest@gmail.com",
    "password": "123456789"
}
``` 
Then you can get the response like:
```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyMCIsInN1YiI6IlVzZXJGb3JUZXN0IiwiaWF0IjoxNTkwMTY0NTUyLCJpc3MiOiJjb20uaGFyZHdvcmtpbmciLCJleHAiOjE1OTA0MjM3NTIsImFsbG93ZWRSZXNvdXJjZSI6Ii9wbGF5ZXJzLC90ZWFtcywvcG9zaXRpb25zLC91c2VycywvcGxheWVyZGF0YSIsImFsbG93ZWRSZWFkUmVzb3VyY2VzIjoiL3BsYXllcnMsL3RlYW1zLC9wb3NpdGlvbnMsL3VzZXJzLC9wbGF5ZXJkYXRhIiwiYWxsb3dlZENyZWF0ZVJlc291cmNlcyI6IiIsImFsbG93ZWRVcGRhdGVSZXNvdXJjZXMiOiIiLCJhbGxvd2VkRGVsZXRlUmVzb3VyY2VzIjoiIn0.NrFruTvulI8dqg48uqBps79UL9PDbHRvWwOq1AF-bpc"    
}
```
This token is need for the future access other api. So you don't need to login to the every API.<br />
DEMO screen shoot:
![Image of login](https://github.com/Hange1995/NBA/blob/master/READMESnapShoot/userLogin.png?raw=true)


- There were comment before every API. Take this get a player by it's name as example.
```
    // http://localhost:8080={prefix}
    //{prefix}/players/name?key=value GET get the player by specific name
        @JsonView(Views.PlayerView.class)
        @RequestMapping(value = "/name", method = RequestMethod.GET)
        public Player getPlayerByName(@RequestParam(value = "name") String name) {
            return playerService.getPlayerByName(name);
        }
```
DEMO screen shoot:
![Image of get](https://github.com/Hange1995/NBA/blob/master/READMESnapShoot/getPlayerByName.png?raw=true)






