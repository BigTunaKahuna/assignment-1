--liquibase formatted sql

--changeset cosmin.mavrichi.22@gmail.com:v1_create_table_reports dbms:sqlite runAlways:false runOnChange:false

CREATE TABLE drug_safety_report
(
    id                INTEGER PRIMARY KEY AUTOINCREMENT,
    reporter_name     TEXT NOT NULL,
    product_name      TEXT NOT NULL,
    issue_description TEXT NOT NULL,
    ts                DATETIME DEFAULT CURRENT_TIMESTAMP,
    status_id         INT  NOT NULL
);