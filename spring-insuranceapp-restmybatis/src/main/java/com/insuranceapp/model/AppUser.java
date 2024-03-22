package com.insuranceapp.model;

import java.util.List;

public class AppUser {
	private String username;
	private int userid;
	private String email;
	private String password;
	private List<String> roles;
	
	public AppUser() {
		super();
	}

	public AppUser(String username, int userid, String email, String password, List<String> roles) {
		super();
		this.username = username;
		this.userid = userid;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "AppUser [username=" + username + ", userid=" + userid + ", email=" + email + ", password=" + password
				+ ", roles=" + roles + "]";
	}
}
