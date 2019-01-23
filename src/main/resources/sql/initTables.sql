// h2 dialect
CREATE TABLE IF NOT EXISTS round
(
  id    INT PRIMARY KEY NOT NULL,
  title VARCHAR2(100)   NOT NULL
);

CREATE TABLE IF NOT EXISTS category
(
  id      INT PRIMARY KEY NOT NULL,
  title   VARCHAR2(100)   NOT NULL,
  roundId INT             NOT NULL,
  FOREIGN KEY (roundId) REFERENCES round (id)
);

CREATE TABLE IF NOT EXISTS tune
(
  id         INT PRIMARY KEY NOT NULL,
  title      VARCHAR2(100)   NOT NULL,
  author     VARCHAR2(100)   NOT NULL,
  score      INT             NOT NULL,
  categoryId INT             NOT NULL,
  FOREIGN KEY (categoryId) REFERENCES category (id)
);

CREATE TABLE IF NOT EXISTS supergame
(
  id     INT PRIMARY KEY NOT NULL,
  title  VARCHAR2(100)   NOT NULL,
  author VARCHAR2(100)   NOT NULL
);

CREATE TABLE IF NOT EXISTS currentDirectory
(
  path VARCHAR2(300) NOT NULL
);