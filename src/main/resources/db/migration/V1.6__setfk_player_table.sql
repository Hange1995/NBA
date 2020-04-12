ALTER TABLE players
    ADD CONSTRAINT player_currentdata_fk FOREIGN KEY ( currentseason_id )
        REFERENCES playerdata ( id );