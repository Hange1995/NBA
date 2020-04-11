--create a table called positions
CREATE TABLE positions (
    /*id                INTEGER NOT NULL default nextval('position_id_seq'), */
    id                BIGSERIAL NOT NULL,
    position_name     VARCHAR(30) not null unique,
    description       VARCHAR(150)
);
--set primary key as position id
ALTER TABLE positions ADD CONSTRAINT position_pk PRIMARY KEY ( id );


--Create a table called players
CREATE TABLE players (
    /*id              INTEGER NOT NULL default nextval('player_id_seq'),*/
    id               BIGSERIAL NOT NULL,
    name             VARCHAR(30) not null unique,
    first_name       VARCHAR(30),
    last_name        VARCHAR(30),
    weight           DOUBLE PRECISION,
    height           DOUBLE PRECISION,
    position_id      BIGINT,
    team_id          BIGINT
);
ALTER TABLE players ADD CONSTRAINT player_pk PRIMARY KEY ( id );


CREATE TABLE teams (
    /*id                INTEGER NOT NULL default nextval('team_id_seq'), */
    id                BIGSERIAL NOT NULL,
    name              VARCHAR(30) not null unique,
    location          VARCHAR(150)
);
ALTER TABLE teams ADD CONSTRAINT team_pk PRIMARY KEY ( id );


