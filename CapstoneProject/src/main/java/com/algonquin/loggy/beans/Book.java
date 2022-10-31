package com.algonquin.loggy.beans;

import java.math.BigDecimal;
import java.sql.Date;

public class Book {
	
	private int id;
	private String author;
	private String title;
	private int ISBN;
	private String Publisher;
	private Date yearPublished;
	private BigDecimal price;
	private String feature;
	private String bookImgPath;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public Date getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(Date yearPublished) {
		this.yearPublished = yearPublished;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getBookImgPath() {
		return bookImgPath;
	}
	public void setBookImgPath(String bookImgPath) {
		this.bookImgPath = bookImgPath;
	}
}
