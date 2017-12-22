package com.coymaple.domain;

public class UserForm {

	private int id;
	private String name;
	private String password;
	private String sex;
	private String email;
	private String nativePlaceName;
	private String hobby;
	
	public UserForm() {}

	public UserForm(int id, String name, String password, String sex, String email, String nativePlaceName,
			String hobby) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.nativePlaceName = nativePlaceName;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getNativePlaceName() {
		return nativePlaceName;
	}

	public void setNativePlaceName(String nativePlaceName) {
		this.nativePlaceName = nativePlaceName;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
}
