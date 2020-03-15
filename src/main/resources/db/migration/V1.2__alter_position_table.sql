--Create a table called position
insert into position (positionname, description) values
('SF', 'The small forward onsidered to be the most versatile of the main five basketball positions'),
('PF', 'The power forward often plays a role similar to that of the center'),
('C', 'The center,usually plays near the baseline or close to the basket'),
('SG', 'The shooting guard (SG) is also known as the two or the off guard'),
('PG','The point guard,typically the teams best ball handler and passer')
;
--set primary key as position id
ALTER TABLE position ADD CONSTRAINT position_pk PRIMARY KEY ( id );
--Create a table called player
CREATE TABLE player (
    /*id              INTEGER NOT NULL default nextval('player_id_seq'),*/
    id              SERIAL NOT NULL,
    name            VARCHAR(30) not null unique,
    first_name      VARCHAR(30),
    last_name       VARCHAR(30),
    weight           VARCHAR(30),
    hight         VARCHAR(30),
	team		  VARCHAR(30),
    position_id   INTEGER NOT NULL,
    team_id        INTEGER NOT NULL
);
insert into player (name, first_name, last_name, weight, hight, position_id,team,team_id) values
('LBJ', 'James', 'LeBorn', '112', '206', 1,'Lakers',2),
('Kobe', 'Kobe', 'Bryant', '96', '198', 4,'Lakers',2),
('Duncan', 'Duncan', 'Tim', '113', '211', 2,'Spurs',5),
('Ginobili', 'Ginobili', 'Manu', '93', '198', 5,'Spurs',5)
;
ALTER TABLE player ADD CONSTRAINT player_pk PRIMARY KEY ( id );
CREATE TABLE team (
    /*id                INTEGER NOT NULL default nextval('team_id_seq'), */
    id                SERIAL NOT NULL,
    Teamname    VARCHAR(30) not null unique,
    location       VARCHAR(150)
);
insert into team (Teamname, location) values
('Heat', 'Miami'),
('Lakers', 'LA'),
('Wizard', 'DC'),
('Bulls', 'Chicago'),
('Spurs','SanAntonio')
;
ALTER TABLE team ADD CONSTRAINT team_pk PRIMARY KEY ( id );
