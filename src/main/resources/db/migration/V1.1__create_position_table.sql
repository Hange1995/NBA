CREATE TABLE position (
    /*id                INTEGER NOT NULL default nextval('position_id_seq'), */
    id                SERIAL NOT NULL,
    positionname    VARCHAR(30) not null unique,
    description       VARCHAR(150)
);
