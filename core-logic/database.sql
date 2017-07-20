CREATE DATABASE library;
USE library;
CREATE TABLE user(
    userId INT (11) UNSIGNED NOT NULL ,
    memberType VARCHAR(45) NOT NULL ,
    userName VARCHAR(45) NOT NULL ,
    userEmail VARCHAR(45),
    PRIMARY KEY (userId)
);
CREATE TABLE book(
    bookId INT (11) UNSIGNED NOT NULL ,
    bookName VARCHAR(45) NOT NULL ,
    bookType VARCHAR(45) NOT NULL ,
    bookAuthor VARCHAR(45) NOT NULL ,
    PRIMARY KEY (bookId)
);