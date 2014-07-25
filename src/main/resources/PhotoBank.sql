--
-- ER/Studio 8.0 SQL Code Generation
-- Company :      vivi
-- Project :      PhotoBank.DM1
-- Author :       viv
--
-- Date Created : Friday, July 25, 2014 14:23:38
-- Target DBMS : PostgreSQL 8.0
--

-- 
-- TABLE: "Albums" 
--

CREATE TABLE Albums(
    album_id      int4    NOT NULL,
    user_id       int4    NOT NULL,
    album_name    text    NOT NULL,
    CONSTRAINT "PK2" PRIMARY KEY (album_id, user_id)
)
;



-- 
-- TABLE: "Photos" 
--

CREATE TABLE Photos(
    photo_id      int4    NOT NULL,
    album_id      int4    NOT NULL,
    user_id       int4    NOT NULL,
    path          text    NOT NULL,
    CONSTRAINT "PK3" PRIMARY KEY (photo_id, album_id, user_id)
)
;



-- 
-- TABLE: "Roles" 
--

CREATE TABLE Roles(
    role_id       int4    NOT NULL,
    user_id       int4    NOT NULL,
    role          text    NOT NULL,
    CONSTRAINT "PK6" PRIMARY KEY (role_id, user_id)
)
;



-- 
-- TABLE: "Users" 
--

CREATE TABLE Users(
    user_id       int4       NOT NULL,
    user_name     text       NOT NULL,
    user_email    text       NOT NULL,
    password      text       NOT NULL,
    blocked       boolean    DEFAULT false NOT NULL,
    CONSTRAINT "PK1" PRIMARY KEY (user_id, user_name, user_email)
)
;



-- 
-- INDEX: "Ref11" 
--

CREATE INDEX "Ref11" ON Albums(user_id)
;
-- 
-- INDEX: "Ref22" 
--

CREATE INDEX "Ref22" ON Photos(user_id, album_id)
;
-- 
-- INDEX: "Ref14" 
--

CREATE INDEX "Ref14" ON Roles(user_id)
;
-- 
-- TABLE: "Photos" 
--

ALTER TABLE Photos ADD CONSTRAINT "RefAlbums21" 
    FOREIGN KEY (album_id, user_id)
    REFERENCES Albums(album_id, user_id) ON DELETE RESTRICT ON UPDATE RESTRICT
;

CREATE SEQUENCE hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

