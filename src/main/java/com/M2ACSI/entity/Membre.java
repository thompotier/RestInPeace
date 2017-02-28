package com.M2ACSI.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Membre {
	
	@Id
	@GeneratedValue
	private int id;
	private String login;
	private String password;
	private String role;
	
	Membre(){
		//JPA
	}
	

	public Membre(int id, String login, String password, String role) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Membre [id=" + id + ", login=" + login + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	
	
}
