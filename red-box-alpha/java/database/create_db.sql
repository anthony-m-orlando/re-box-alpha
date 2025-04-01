-- **************************************************************
-- This script destroys and recreates the Database
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'bdnd01';

--Drop the DB
DROP DATABASE IF EXISTS bdnd01;

--Create the DB
CREATE DATABASE bdnd01
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;


-- ********************************************************************************
-- Create the logical schema with owner postgres
-- ********************************************************************************
DROP SCHEMA IF EXISTS appcon, bdnd01, lore;

CREATE SCHEMA appcon AUTHORIZATION postgres;
CREATE SCHEMA bdnd01 AUTHORIZATION postgres;
CREATE SCHEMA lore AUTHORIZATION postgres;


-- ********************************************************************************
-- Create the redbox application user  and grant them the necessary permissions
-- ********************************************************************************
DROP USER IF EXISTS ggygax;

CREATE USER ggygax
WITH PASSWORD 'x!WIs$6k@69B'; --Needs to be externalized

GRANT SELECT, INSERT, UPDATE
ON ALL TABLES IN SCHEMA appcon
TO ggygax;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA appcon
TO ggygax;

GRANT SELECT, INSERT, UPDATE
ON ALL TABLES IN SCHEMA bdnd01
TO ggygax;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA bdnd01
TO ggygax;

GRANT SELECT, INSERT, UPDATE
ON ALL TABLES IN SCHEMA lore
TO ggygax;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA lore
TO ggygax;


