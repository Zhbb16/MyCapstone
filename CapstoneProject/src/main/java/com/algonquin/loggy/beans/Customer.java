package com.algonquin.loggy.beans;

public class Customer extends User {
	
	private String address;
	private String creditCardInfo;
	
	public Customer() {
		super();
	}
	
	public Customer (String address, String creditCardInfo) {
		this.setAddress(address);
		this.setCreditCardInfo(creditCardInfo);
	}
	
//	public Customer (UUID id, String username, String password, String firstName, String lastName, String address, String creditCardInfo) {
//		super(id, username, password, firstName, lastName);
//		this.setAddress(address);
//		this.setCreditCardInfo(creditCardInfo);
//	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreditCardInfo() {
		return creditCardInfo;
	}

	public void setCreditCardInfo(String creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}
}	
	
	
