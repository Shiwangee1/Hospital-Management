package com.Entity;

public class User {
	private int id;
	private String fullName;
	private String Email;
	private String pasword;

	public User(String fullName, String email, String pasword) {
		super();
		this.fullName = fullName;
		Email = email;
		this.pasword = pasword;
	}

	public User(int id, String fullName, String email, String pasword) {
		super();
		this.id = id;
		this.fullName = fullName;
		Email = email;
		this.pasword = pasword;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

}
