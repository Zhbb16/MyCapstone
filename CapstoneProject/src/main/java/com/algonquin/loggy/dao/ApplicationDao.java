package com.algonquin.loggy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.algonquin.loggy.beans.Book;
import com.algonquin.loggy.beans.User;
import com.algonquin.loggy.dao.DBConnection;
import com.algonquin.loggy.services.ApplicationServices;


public class ApplicationDao implements ApplicationServices{
	


//------------------Sign Up/In/Out users
	public int registerUser(User user) {
		int rowsAffected = 0;

		try {
			// get the connection for the database
			Connection connection = DBConnection.getConnectionToDatabase();

			// write the insert query-? are the place holder for the usename, password, fname, lname,...
			String insertQuery = "insert into users values(?,?,?,?,?)";

			// set parameters with PreparedStatement
			java.sql.PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setString(5, user.getEmail());
		

// 			execute the statement-the executeUpdate API give how many rows got affected due to the operation
//			in the form of an integer.
			rowsAffected = statement.executeUpdate();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
//		so the rows affected is going to go back to calling method
//		which will indicate to the calling method that you were able to successfully
//		insert a record or not in the database
		return rowsAffected;
	}

}
	
//------------------CURD operation on user profile

	
//-------------search Books
//	add a method to search the database for the books and return the search result
	public List<Book> searchBooks(String searchString) {
		Book book = null;
		List<Book> books = new ArrayList<>();

		try {
//			get a connection
			Connection connection = DBConnection.getConnectionToDatabase();
		
//			writes the query to search the books
			String sql = "select * from books where author like'%"+searchString+"%'";
			
//			create a statement
			Statement statement = connection.createStatement();
			
//			take all the rows inside the result set
			ResultSet set = statement.executeQuery(sql);
			
//			iterates it and fills every rows into a books object
			while(set.next()) {
				book = new Book();
//				book.setId(set.getInt("id"));
				book.setTitle(set.getString("title"));

				books.add(book);
			}	
		}catch(SQLException exception){
		exception.printStackTrace();
		}
		
//		return that books list to the calling method
		return books;
	}
}

