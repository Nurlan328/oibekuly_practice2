
create schema parameter_specific_catalog not exists oibekuly;

CREATE TABLE IF NOT EXISTS BANK (
    ID int NOT NULL,
    BANKNAME VARCHAR(60),
    CUSTOMERACCOUNTNUMBER int,
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS CUSTOMERS (
      ID integer NOT NULL,
      FIRSTNAME VARCHAR(60),
      LASTNAME VARCHAR(60),
      AGE integer,
      ADDRESS VARCHAR(60),
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS ACCOUNT (
     ACCOUNTNUMBER bigserial NOT NULL,
     BALANCE double precision,
     INTEREST double precision
);

select * from bank;
select * from CUSTOMERS;
select * from ACCOUNT;

-- drop table BANK;