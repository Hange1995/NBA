CREATE TABLE positions (
    /*id                INTEGER NOT NULL default nextval('position_id_seq'), */
    id                BIGSERIAL NOT NULL,
    position_name     VARCHAR(30) not null unique,
    description       VARCHAR(150)
);
--set primary key as position id
ALTER TABLE positions ADD CONSTRAINT position_pk PRIMARY KEY ( id );
