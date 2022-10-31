package com.algonquin.loggy.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

//	 CREATE DATABASE bookNookDB DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
//	 USE bookNookDB;
//	 CREATE TABLE books(
//	        id INT(10) NOT NULL AUTO_INCREMENT,
//	        author CHAR(128),
//	        title CHAR(128),
//	        ISBN VARCHAR(17),
//	        publisher CHAR(128),
//	        yearPublished CHAR(4),
//	        price DECIMAL(7,2),
//	        feature CHAR(128),
//	        PRIMARY KEY (id)
//	);
//	 CREATE TABLE users(
//	        uuid CHAR(40) NOT NULL,
//	        firstName CHAR(128),
//	        LastName CHAR(128),
//	        username CHAR(128),
//	        password CHAR(128),
//	        PRIMARY KEY (uuid)
//	);
//	INSERT INTO books (author, title, ISBN, publisher, yearPublished, price, feature)
//	VALUES ('J. K. Rowling', 'Harry Potter', '9780747532743', 'Bloomsbury Publishing', '1997', '89.99', 'Signed copy');
//	INSERT INTO books (author, title, ISBN, publisher, yearPublished, price, feature)
//	VALUES ('James Clear', 'Atomic Habits', '9781078163583', 'Avery', '2018', '21.66', ' Limited Editions');

    public static Connection getConnectionToDatabase() {
        Connection connection = null;

        System.out.println("getConnectionToDatabase.");

        try {
            // load the driver class
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");

            // get hold of the DriverManager
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bookNookDB", "root", "");

        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();

        }

        catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (connection != null) {
            System.out.println("Connection made to DB!");

        }

        return connection;
    }

}








