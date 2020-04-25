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
3. Used JDBC to connect project with Postgres
4. Configured Spring Security for Authentication
5. Created repository, service and did test
6. Created Controllers and Restful APIs
7. Did mock test for AWS S3 Storage service
8. Integrated third-party application AWS SQS and did Mock test
 
    

## Build Project
1.Clone the project
```
git clone https://github.com/Hange1995/NBA.git
```
## Compile

## Test****
## Run Migration
## Package
## API guildline
## ScreenShoot DEMO




