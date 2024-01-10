package com.Entity;

public class Specalist {

	private int id;
	private String SpeciallistName;
	public Specalist(int id, String speciallistName) {
		super();
		this.id = id;
		SpeciallistName = speciallistName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpeciallistName() {
		return SpeciallistName;
	}
	public void setSpeciallistName(String speciallistName) {
		SpeciallistName = speciallistName;
	}
	public Specalist() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
