package com.algonquin.loggy.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.loggy.beans.User;
import com.algonquin.loggy.dao.ApplicationDao;


@WebServlet("/registerUser")
public class UserServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    
//    UUID this should be used here

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// collect all form data
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String id = req.getParameter("id");
		String email = req.getParameter("email");

		
		// fill it up in a bean- by crating an instance of User class in Beans
		User user = new User(username, password, firstName, lastName, id, email);
				

		// call DAO layer and save the user object to DB
		ApplicationDao dao = new ApplicationDao();
		int rows = dao.registerUser(user);
		

		// prepare an information message for user about the success or failure of the operation
		String infoMessage = null;
		if(rows==0){
			infoMessage="Sorry, an error occurred!";
		}
		else{
			infoMessage="User registered successfully!";
		}

		// write the message back to the page in client browser we need the below method to convert html to string
		String page = getHTMLString(req.getServletContext().getRealPath("/index.html"), infoMessage);
			//get the response object and write this entire page back to the client
		resp.getWriter().write(page);
				
				
	}
	
//	this part is copied directly form SearchServlet.java- just the parameters are changed
	public String getHTMLString(String filePath, String message) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line="";
		StringBuffer buffer = new StringBuffer();
		while((line=reader.readLine())!=null){
			buffer.append(line);
		}
		
		reader.close();
		String page = buffer.toString();
		
//		in this part we just need the data that needs to get formatted in the respective place holder on that page
		page = MessageFormat.format(page, message);
		
		return page;
		
		
	}
	
//	add doGet method here to get us to the register.html file
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
																						// here the message string is empty 
																						// when the page loads for the fist time		
		String page = getHTMLString(req.getServletContext().getRealPath("/index.html"), "");
//		get the response object and write this entire page back to the client
		resp.getWriter().write(page);
	}

	
    
}
