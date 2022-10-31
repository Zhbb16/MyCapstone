package com.algonquin.loggy.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.loggy.beans.Book;
import com.algonquin.loggy.dao.ApplicationDao;
import com.test.beans.Product;

@WebServlet("/searchBook")
public class SearchServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// collect all Form data
		String searchString = req.getParameter("search");
//		String author = req.getParameter("author");
//		add other book args	

		// call DAO layer and save the user object to DB
		ApplicationDao dao = new ApplicationDao();
		List<Book> books = dao.searchBooks(searchString);
		
		//write the books data back to the client browser
		// for this purpose we use the below function-because the servlet only can read string
		String page = getHTMLString(req.getServletContext().getRealPath("/html/searchResults.html"), books);
		resp.getWriter().write(page);	
}
		
//	  this methods reads the HTML template as a String, replaces place holders
//	 with the values and returns the entire page as a String
	public String getHTMLString(String filePath, List<Book> books) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line="";
		StringBuffer buffer = new StringBuffer();
//		if it is null it is the end of the list
		while((line=reader.readLine())!=null){
			buffer.append(line);
		}
		
		reader.close();
//		empty the entire content of the buffer as a string value there
		String page = buffer.toString();
		
//		format the page which is the page itself to be formatted and all the data to be replaced in the palce holders
//		only 3 product are set to be shown here- fetch products by their index
//		the last 0 is the action placeholder for items in the card		
		page = MessageFormat.format(page, books.get(0).getBookImgPath(),
				books.get(1).getBookImgPath(),books.get(2).getPBookImgPath(),
				books.get(0).getBookName(),books.get(1).getBookName(),
				books.get(2).getBookName(),0);
		return page;
	}
}