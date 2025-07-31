-- V1__create_user_story_table.sql


CREATE TABLE user_story (
    id INTEGER PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status INTEGER,
    creation_time TIMESTAMP,
    start_time TIMESTAMP,
    last_update TIMESTAMP
);

CREATE SEQUENCE user_story_seq START WITH 11 INCREMENT BY 1;

