package com.example.hanoiguide_lichtrinh.entity;

import java.io.Serializable;

public class ItemTest implements Serializable{

	int imageResource;
	String text;

	public int getImageResource() {
		return imageResource;
	}

	public void setImageResource(int imageResource) {
		this.imageResource = imageResource;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ItemTest(int imageResource, String text) {
		super();
		this.imageResource = imageResource;
		this.text = text;
	}

	public ItemTest() {
		super();
	}	
	

}
