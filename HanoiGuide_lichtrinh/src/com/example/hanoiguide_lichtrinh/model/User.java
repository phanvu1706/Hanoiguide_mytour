package com.example.hanoiguide_lichtrinh.model;

public class User {
	private String user_id;
	private String sdt;
	private String ava;
	private String name;
	private String internal_name;
	
	public User() {
		
	}

	public String getAva() {
		return ava;
	}

	public void setAva(String ava) {
		this.ava = ava;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInternal_name() {
		return internal_name;
	}

	public void setInternal_name(String internal_name) {
		this.internal_name = internal_name;
	}

	public User(String user_id, String sdt, String ava, String name,
			String internal_name) {
		super();
		this.user_id = user_id;
		this.sdt = sdt;
		this.ava = ava;
		this.name = name;
		this.internal_name = internal_name;
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
