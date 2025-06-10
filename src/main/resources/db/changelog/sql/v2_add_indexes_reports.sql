--liquibase formatted sql

--changeset cosmin.mavrichi.22@gmail.com:v2_add_indexes_reports dbms:sqlite runAlways:false runOnChange:false

CREATE INDEX idx_product_name ON drug_safety_report (product_name);

CREATE INDEX idx_ts ON drug_safety_report (ts DESC);

CREATE INDEX idx_status_id ON drug_safety_report (status_id);

CREATE INDEX idx_ts_status_id_product_name ON drug_safety_report (ts DESC, status_id, product_name);