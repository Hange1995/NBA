ALTER TABLE player
    ADD CONSTRAINT player_position_fk FOREIGN KEY ( position_id )
        REFERENCES position ( id );

ALTER TABLE player
    ADD CONSTRAINT player_team_fk FOREIGN KEY ( team_id )
        REFERENCES team ( id );