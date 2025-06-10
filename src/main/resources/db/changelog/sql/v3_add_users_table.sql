--liquibase formatted sql

--changeset cosmin.mavrichi.22@gmail.com:v3_add_users_table dbms:sqlite runAlways:false runOnChange:false

CREATE TABLE users
(
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    enabled  BOOLEAN      NOT NULL
);

CREATE TABLE authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);