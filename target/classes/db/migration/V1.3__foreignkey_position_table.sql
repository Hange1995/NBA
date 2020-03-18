ALTER TABLE players
    ADD CONSTRAINT player_position_fk FOREIGN KEY ( position_id )
        REFERENCES positions ( id );

ALTER TABLE players
    ADD CONSTRAINT player_team_fk FOREIGN KEY ( team_id )
        REFERENCES teams ( id );