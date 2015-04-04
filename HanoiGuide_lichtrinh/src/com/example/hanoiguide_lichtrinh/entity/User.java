package com.example.hanoiguide_lichtrinh.entity;

public class User {
	private String user_id;
	private String sdt;
	
	public User() {
		
	}

	public User(String user_id, String sdt) {
		super();
		this.user_id = user_id;
		this.sdt = sdt;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
}
