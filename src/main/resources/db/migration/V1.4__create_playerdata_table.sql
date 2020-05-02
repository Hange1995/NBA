CREATE TABLE seasondata (
    /*id              INTEGER NOT NULL default nextval('playerdata_id_seq'),*/
    id              BIGSERIAL NOT NULL,
    player_id       BIGINT,
    season          BIGINT NOT NULL,
    salary          DOUBLE PRECISION,
    steal           DOUBLE PRECISION,
    block           DOUBLE PRECISION,
    assistant       DOUBLE PRECISION,
    score           DOUBLE PRECISION,
    appearances     BIGINT


);
ALTER TABLE seasondata ADD CONSTRAINT seasondata_pk PRIMARY KEY ( id );

ALTER TABLE seasondata
    ADD CONSTRAINT seasondata_player_fk FOREIGN KEY ( player_id )
        REFERENCES players ( id );