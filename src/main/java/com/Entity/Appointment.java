package com.Entity;

public class Appointment {
	
	private int id;
	private int  userid;

	private String fullname;
	private String Gender;
	private int age;
	private String appointmentdate;
	private String Email;
	private String phno;
	private String disease;
	private int docterId;
	private String Address;
	private String App_status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAppointmentdate() {
		return appointmentdate;
	}
	public void setAppointmentdate(String appointmentdate) {
		this.appointmentdate = appointmentdate;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	
	public int getDocterId() {
		return docterId;
	}
	public void setDocterId(int docterId) {
		this.docterId = docterId;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getApp_status() {
		return App_status;
	}
	public void setApp_status(String app_status) {
		this.App_status = app_status;
	}
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Appointment(int userid, String fullname, String gender, int age, String appointmentdate, String email,
			String phno, String disease, int docterId, String address, String app_status) {
		super();
		this.userid = userid;
		this.fullname = fullname;
		Gender = gender;
		this.age = age;
		this.appointmentdate = appointmentdate;
		Email = email;
		this.phno = phno;
		this.disease = disease;
		this.docterId = docterId;
		Address = address;
		App_status = app_status;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
