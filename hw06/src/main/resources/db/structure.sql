DROP TABLE IF EXISTS HW_COMMENT;
DROP TABLE IF EXISTS HW_BOOK;
DROP TABLE IF EXISTS HW_AUTHOR;
DROP TABLE IF EXISTS HW_GENRE;
DROP INDEX IF EXISTS HW_BOOK_K01;
DROP INDEX IF EXISTS HW_AUTHOR_K01;
DROP INDEX IF EXISTS HW_GENRE_K01;
DROP INDEX IF EXISTS HW_COMMENT_K01;

CREATE TABLE HW_AUTHOR(
    AUTHORID SERIAL PRIMARY KEY,
    AUTHORNAME VARCHAR(1024) NOT NULL UNIQUE
);
CREATE INDEX HW_AUTHOR_K01 ON HW_AUTHOR(UPPER(AUTHORNAME));

CREATE TABLE HW_GENRE(
    GENREID SERIAL PRIMARY KEY,
    GENRENAME VARCHAR(255) NOT NULL UNIQUE
);
CREATE INDEX HW_GENRE_K01 ON HW_GENRE(UPPER(GENRENAME));

CREATE TABLE HW_BOOK(
    BOOKID SERIAL PRIMARY KEY,
    BOOKNAME VARCHAR(1024) NOT NULL,
    AUTHORID INTEGER NOT NULL,
    GENREID INTEGER NOT NULL,
    UNIQUE (BOOKNAME, AUTHORID),
    CONSTRAINT HW_BOOK_FK01 FOREIGN KEY (AUTHORID) REFERENCES HW_AUTHOR (AUTHORID) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT HW_BOOK_FK02 FOREIGN KEY (GENREID) REFERENCES HW_GENRE (GENREID) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE INDEX HW_BOOK_K01 ON HW_BOOK(UPPER(BOOKNAME));

CREATE TABLE HW_COMMENT(
    COMMENTID SERIAL PRIMARY KEY,
    BOOKID INTEGER NOT NULL,
    COMMENT VARCHAR(4000) NOT NULL,
    CONSTRAINT HW_COMMENT_FK01 FOREIGN KEY (BOOKID) REFERENCES HW_BOOK (BOOKID) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE INDEX HW_COMMENT_K01 ON HW_COMMENT(BOOKID);