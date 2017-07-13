CREATE DATABASE IF NOT EXISTS library;

USE library;

CREATE TABLE tbl_role (
  id        INT                                 NOT NULL PRIMARY KEY AUTO_INCREMENT,
  role_name VARCHAR(15)                         NOT NULL UNIQUE,
  created   TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
  modified  TIMESTAMP                           NULL,
  deleted   TIMESTAMP                           NULL
);

CREATE TABLE tbl_user (
  id           INT                                 NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_name    VARCHAR(45)                         NOT NULL UNIQUE,
  password     VARCHAR(32)                         NOT NULL,
  user_role_id INT                                 NOT NULL,
  created      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
  modified     TIMESTAMP                           NULL,
  deleted      TIMESTAMP                           NULL
);

CREATE TABLE tbl_author (
  id         INT                                 NOT NULL PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(100)                        NOT NULL,
  last_name  VARCHAR(100)                        NOT NULL,
  birthday   TIMESTAMP                           NOT NULL,
  created    TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
  modified   TIMESTAMP                           NULL,
  deleted    TIMESTAMP                           NULL
);

CREATE TABLE tbl_genre (
  id       INT                                 NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name     VARCHAR(100)                        NOT NULL UNIQUE,
  created  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
  modified TIMESTAMP                           NULL,
  deleted  TIMESTAMP                           NULL
);

CREATE TABLE tbl_book_genres (
  id       INT                                 NOT NULL PRIMARY KEY AUTO_INCREMENT,
  genre_id INT                                 NOT NULL,
  book_id  INT                                 NOT NULL,
  created  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
  modified TIMESTAMP                           NULL,
  deleted  TIMESTAMP                           NULL
);

CREATE TABLE tbl_book_authors (
  id        INT                                 NOT NULL PRIMARY KEY AUTO_INCREMENT,
  author_id INT                                 NOT NULL,
  book_id   INT                                 NOT NULL,
  created   TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
  modified  TIMESTAMP                           NULL,
  deleted   TIMESTAMP                           NULL
);

CREATE TABLE tbl_publisher (
  id       INT                                 NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name     VARCHAR(100)                        NOT NULL UNIQUE,
  created  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
  modified TIMESTAMP                           NULL,
  deleted  TIMESTAMP                           NULL
);

CREATE TABLE tbl_book (
  id           INT                                 NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name         VARCHAR(45)                         NOT NULL,
  description  TEXT                                NOT NULL,
  file         VARCHAR(500),
  page_count   INT(11)                             NOT NULL,
  publisher_id INT                                 NOT NULL,
  publish_year TIMESTAMP                           NOT NULL,
  user_id      INT                                 NOT NULL,
  image        VARCHAR(500),
  created      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
  modified     TIMESTAMP                           NULL,
  deleted      TIMESTAMP                           NULL
);

ALTER TABLE tbl_user
  ADD CONSTRAINT fk_roles FOREIGN KEY (user_role_id) REFERENCES tbl_role (id);

ALTER TABLE tbl_book_authors
  ADD CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES tbl_author (id);

ALTER TABLE tbl_book_authors
  ADD CONSTRAINT fk_book_author FOREIGN KEY (book_id) REFERENCES tbl_book (id);

ALTER TABLE tbl_book_genres
  ADD CONSTRAINT fk_genre FOREIGN KEY (genre_id) REFERENCES tbl_genre (id);

ALTER TABLE tbl_book_genres
  ADD CONSTRAINT fk_book_genre FOREIGN KEY (book_id) REFERENCES tbl_book (id);

ALTER TABLE tbl_book
  ADD CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES tbl_user (id);

ALTER TABLE tbl_book
  ADD CONSTRAINT fk_publisher FOREIGN KEY (publisher_id) REFERENCES tbl_publisher (id);