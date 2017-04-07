package model;

import java.io.Serializable;

public class User implements Serializable {
	private String firstName, lastName, username, password;
	// private Albums (need to decide to datastructure for this
	
	// Regular Constructor 
	// Possibly for fancy functionality have method to check password strength;
	public User(String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;

	}
	
	// Overloaded Constructor for single name given
	public User(String firstName, String username, String password) {
		this.firstName = firstName;
		this.username = username;
		this.password = password;
	}
	
	// Getters 
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
}
