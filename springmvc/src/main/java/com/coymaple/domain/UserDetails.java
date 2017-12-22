package com.coymaple.domain;

public class UserDetails {
	private int id;
	private String nativePlaceCode;
	private String hobbyCode;
	
	public UserDetails() {}
	
	public UserDetails(String nativePlaceCode, String hobbyCode) {
		super();
		this.nativePlaceCode = nativePlaceCode;
		this.hobbyCode = hobbyCode;
	}

	public UserDetails(int id, String nativePlaceCode, String hobbyCode) {
		super();
		this.id = id;
		this.nativePlaceCode = nativePlaceCode;
		this.hobbyCode = hobbyCode;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNativePlaceCode() {
		return nativePlaceCode;
	}
	public void setNativePlaceCode(String nativePlaceCode) {
		this.nativePlaceCode = nativePlaceCode;
	}
	public String getHobbyCode() {
		return hobbyCode;
	}
	public void setHobbyCode(String hobbyCode) {
		this.hobbyCode = hobbyCode;
	}
	
	
}
