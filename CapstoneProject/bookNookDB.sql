 -- Database Schema for Capstone Project
 CREATE DATABASE bookNookDB DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
 USE bookNookDB;
 
 -- Reset tables before instantiating
 DROP TABLE IF EXISTS Book;
 DROP TABLE IF EXISTS BN_User;
 
 CREATE TABLE Book(
        id INT(10) NOT NULL AUTO_INCREMENT,
        author CHAR(128),
        title CHAR(128),
        ISBN VARCHAR(17),
        publisher CHAR(128),
        yearPublished CHAR(4),
        price DECIMAL(7,2),
        feature CHAR(128),
        PRIMARY KEY (id)
);
 CREATE TABLE BN_User(
        uuid CHAR(40) NOT NULL,
        firstName CHAR(128),
        lastName CHAR(128),
        email CHAR(128), 
        username CHAR(128),
        password CHAR(128),
        PRIMARY KEY (uuid)
);

INSERT INTO Book (author, title, ISBN, publisher, yearPublished, price, feature) VALUES 
('J. K. Rowling', 'Harry Potter', '9780747532743', 'Bloomsbury Publishing', '1997', '89.99', 'Signed copy'), 
('James Clear', 'Atomic Habits', '9781078163583', 'Avery', '2018', '21.66', ' Limited Editions'); 
INSERT INTO BN_User (uuid, firstName, lastName, email, userName, password) VALUES 
('001', 'Zahra', 'Habibi', 'z@h.com', 'zhabibi', 'zhpassword'), 
('002', 'Saira', 'Qureshiwennekers', 's@q.com', 'squreshiwennikers', 'sqpassword'), 
('003', 'Alex', 'Muns', 'a@m.com', 'amuns', 'ampassword'); 