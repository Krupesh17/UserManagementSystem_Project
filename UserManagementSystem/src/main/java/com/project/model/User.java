package com.project.model;

public class User {

	private int userId;
	private String firstName;
	private String lastName;
	private String contact;
	private String email;
	private String password;
	private String role = "user";
	
// CONSTRUCTORS 
	public User() {
		super();
	}

	public User(String role) {
		
		this.role = role;
	}
	
	public User(int userId, String firstName, String lastName, String contact, String email, String password,
			String role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.role = role;
	}


	public User(String firstName, String lastName, String contact, String email, String password, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	
// GETTER & SETTER.
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getContact() {
		return contact;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return role;
	}
	
	
}
