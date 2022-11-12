package com.cims.structure;

public class User {

	private String email;
	private String password;
	private String city;

	public User(String email, String password, String city) {
		super();
		this.email = email;
		this.password = password;
		this.city = city;
	}

	public User() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", city=" + city + "]";
	}

}
