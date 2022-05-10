-- COURSE TABLE
DROP TABLE IF EXISTS course;

TRUNCATE TABLE course;

CREATE TABLE IF NOT EXISTS course (
    id          serial primary key,
    name        varchar(255),
    description varchar(255),
    end_date    date,
    start_date  date
    );

-- USR TABLE
DROP TABLE IF EXISTS usr;

TRUNCATE TABLE usr;

CREATE TABLE IF NOT EXISTS usr (
    id         serial primary key,
    first_name varchar(255),
    last_name  varchar(255),
    login      varchar(255),
    password   varchar(255),
    role       varchar(255)
    );
