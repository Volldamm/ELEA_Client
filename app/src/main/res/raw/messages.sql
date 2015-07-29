--
-- File generated with SQLiteStudio v3.0.6 on lun jul 13 18:00:50 2015
--
-- Text encoding used: windows-1252
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: messages
DROP TABLE IF EXISTS messages;
CREATE TABLE messages (ID integer NOT NULL,SENDER_ID integer NOT NULL,RECEIVER_ID integer NOT NULL,JOB_ID integer,MESSAGE_TEXT varchar(4000) NOT NULL,SUBJECT varchar(150),DATE_CREATED integer,DATE_MODIFIED integer,DATE_DELETED integer,IS_READED integer,PRIMARY KEY (ID));

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;