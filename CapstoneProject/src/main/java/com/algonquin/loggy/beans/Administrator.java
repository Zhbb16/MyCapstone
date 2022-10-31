package com.algonquin.loggy.beans;

public class Administrator extends User {
	
	private String adminName;
	
	public Administrator() {
		super();
	}
	
	public Administrator (String adminName, String email) {
		super(email);
		this.adminName = adminName;
	}
	
//	public Administrator(UUID id, String username, String password, String firstName, String lastName,String adminName, String email) {
//		super(id, username, password, email, firstName, lastName);
//		this.adminName = adminName;
//	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
}
