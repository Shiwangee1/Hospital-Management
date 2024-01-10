package com.Entity;

public class Docter_Entity {
	public Docter_Entity(String fullName, String dOB, String qulification, String specialist, String email,
			String mobile, String password) {
		super();
		FullName = fullName;
		DOB = dOB;
		Qulification = qulification;
		Specialist = specialist;
		Email = email;
		Mobile = mobile;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	private int id;
	private  String FullName;
	private String DOB;
	private String Qulification;
	private String Specialist;
	private String Email;
	private String Mobile;
	private String password;
	
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getDOB() {
		return DOB;
	}
	public Docter_Entity(int id, String fullName, String dOB, String qulification, String specialist, String email,
			String mobile) {
		super();
		this.id = id;
		FullName = fullName;
		DOB = dOB;
		Qulification = qulification;
		Specialist = specialist;
		Email = email;
		Mobile = mobile;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getQulification() {
		return Qulification;
	}
	public Docter_Entity(int id, String fullName, String dOB, String qulification, String specialist, String email,
			String mobile, String password) {
		super();
		this.id = id;
		FullName = fullName;
		DOB = dOB;
		Qulification = qulification;
		Specialist = specialist;
		Email = email;
		Mobile = mobile;
		this.password = password;
	}
	public Docter_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setQulification(String qulification) {
		Qulification = qulification;
	}
	public String getSpecialist() {
		return Specialist;
	}
	public void setSpecialist(String specialist) {
		Specialist = specialist;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
