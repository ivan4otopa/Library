--------------------------------------------------------
--  File created - Saturday-April-09-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table AUTHORITIES
--------------------------------------------------------

  CREATE TABLE "AUTHORITIES" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(20)
   )
--------------------------------------------------------
--  DDL for Table BOOKS
--------------------------------------------------------

  CREATE TABLE "BOOKS" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(30), 
	"AUTHOR" VARCHAR2(50), 
	"YEAR_OF_PUBLISHING" NUMBER
   )
--------------------------------------------------------
--  DDL for Table CLIENTS
--------------------------------------------------------

  CREATE TABLE "CLIENTS" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(30), 
	"DATE_OF_BIRTH" DATE, 
	"PID" VARCHAR2(50)
   )
--------------------------------------------------------
--  DDL for Table LENDS
--------------------------------------------------------

  CREATE TABLE "LENDS" 
   (	"ID" NUMBER, 
	"BOOK_ID" NUMBER, 
	"CLIENT_ID" NUMBER, 
	"DATE_OF_LENDING" DATE, 
	"DATE_OF_RETURN" DATE, 
	"PERIOD" NUMBER
   )
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "USERS" 
   (	"ID" NUMBER, 
	"USERNAME" VARCHAR2(30), 
	"PASSWORD" VARCHAR2(50), 
	"NAME" VARCHAR2(50), 
	"STATUS" VARCHAR2(50)
   )
--------------------------------------------------------
--  DDL for Table USERS_AUTHORITIES
--------------------------------------------------------

  CREATE TABLE "USERS_AUTHORITIES" 
   (	"USER_ID" NUMBER, 
	"AUTHORITY_ID" NUMBER
   )
REM INSERTING into AUTHORITIES
SET DEFINE OFF;
Insert into AUTHORITIES (ID,NAME) values (1,'ROLE_ADMIN');
Insert into AUTHORITIES (ID,NAME) values (2,'ROLE_USER');
REM INSERTING into BOOKS
SET DEFINE OFF;
REM INSERTING into CLIENTS
SET DEFINE OFF;
REM INSERTING into LENDS
SET DEFINE OFF;
REM INSERTING into USERS
SET DEFINE OFF;
Insert into USERS (ID,USERNAME,PASSWORD,NAME,STATUS) values (1,'ivan','c4ca4238a0b923820dcc509a6f75849b','ivan','Active');
REM INSERTING into USERS_AUTHORITIES
SET DEFINE OFF;
Insert into USERS_AUTHORITIES (USER_ID,AUTHORITY_ID) values (1,1);
Insert into USERS_AUTHORITIES (USER_ID,AUTHORITY_ID) values (1,2);
--------------------------------------------------------
--  Constraints for Table AUTHORITIES
--------------------------------------------------------

  ALTER TABLE "AUTHORITIES" ADD PRIMARY KEY ("ID") ENABLE
--------------------------------------------------------
--  Constraints for Table BOOKS
--------------------------------------------------------

  ALTER TABLE "BOOKS" ADD PRIMARY KEY ("ID") ENABLE
--------------------------------------------------------
--  Constraints for Table CLIENTS
--------------------------------------------------------

  ALTER TABLE "CLIENTS" ADD PRIMARY KEY ("ID") ENABLE
--------------------------------------------------------
--  Constraints for Table LENDS
--------------------------------------------------------

  ALTER TABLE "LENDS" ADD PRIMARY KEY ("ID") ENABLE
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "USERS" ADD PRIMARY KEY ("ID") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table LENDS
--------------------------------------------------------

  ALTER TABLE "LENDS" ADD CONSTRAINT "FK_LEND_BOOK" FOREIGN KEY ("BOOK_ID")
	  REFERENCES "BOOKS" ("ID") ON DELETE CASCADE ENABLE
  ALTER TABLE "LENDS" ADD CONSTRAINT "FK_LEND_CLIENT" FOREIGN KEY ("CLIENT_ID")
	  REFERENCES "CLIENTS" ("ID") ON DELETE CASCADE ENABLE
--------------------------------------------------------
--  Ref Constraints for Table USERS_AUTHORITIES
--------------------------------------------------------

  ALTER TABLE "USERS_AUTHORITIES" ADD CONSTRAINT "FK_USERS_AUTHORITIES_AUTHORITY" FOREIGN KEY ("AUTHORITY_ID")
	  REFERENCES "AUTHORITIES" ("ID") ENABLE
  ALTER TABLE "USERS_AUTHORITIES" ADD CONSTRAINT "FK_USERS_AUTHORITIES_USER" FOREIGN KEY ("USER_ID")
	  REFERENCES "USERS" ("ID") ENABLE
