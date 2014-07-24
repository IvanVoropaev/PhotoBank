--
-- ER/Studio 8.0 SQL Code Generation
-- Company :      vivi
-- Project :      DATA MODEL
-- Author :       viv
--
-- Date Created : Tuesday, July 08, 2014 11:40:26
-- Target DBMS : PostgreSQL 8.0
--

-- 
-- TABLE: "Albums" 
--

CREATE TABLE Albums (
    album_id      int4        NOT NULL,
    user_id       int4        NOT NULL,
    album_name    char(30)    NOT NULL,
    CONSTRAINT "PK2" PRIMARY KEY (album_id, user_id)
)
;



-- 
-- TABLE: "Photos" 
--

CREATE TABLE Photos (
    photo_id    int4         NOT NULL,
    album_id    int4         NOT NULL,
    user_id     int4         NOT NULL,
    path        char(100)    NOT NULL,
    CONSTRAINT "PK3" PRIMARY KEY (photo_id, album_id, user_id)
)
;



-- 
-- TABLE: "Users" 
--

CREATE TABLE Users (
    user_id      int4        NOT NULL,
    user_name    char(10)    NOT NULL,
    user_email   char(40)    NOT NULL,
    password     char(10)    NOT NULL,
    user_role    char(10),
    CONSTRAINT "PK1" PRIMARY KEY (user_id)
)
;



-- 
-- INDEX: "Ref11" 
--

CREATE INDEX "Ref11" ON Albums (user_id)
;
-- 
-- INDEX: "Ref22" 
--

CREATE INDEX "Ref22" ON Photos (album_id, user_id)
;
-- 
-- TABLE: "Albums" 
--

ALTER TABLE Albums ADD CONSTRAINT "RefUsers11" 
    FOREIGN KEY (user_id)
    REFERENCES Users (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT
;


-- 
-- TABLE: "Photos" 
--

ALTER TABLE Photos ADD CONSTRAINT "RefAlbums21" 
    FOREIGN KEY (album_id, user_id)
    REFERENCES Albums (album_id, user_id) ON DELETE RESTRICT ON UPDATE RESTRICT
;


