package com.coymaple.domain;

public class User {
	private long id;
	private String userName;
	private String password;
	private String sex;
	private String email;
	
	public User() {}
	
	public User(String userName, String password, String sex, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.email = email;
	}

	public User(long id, String userName, String password, String sex, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.email = email;
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
