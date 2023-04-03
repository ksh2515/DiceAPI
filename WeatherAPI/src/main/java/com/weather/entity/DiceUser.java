package com.weather.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userDetails")
public class DiceUser {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "username")
	private String userName;
	private String password;
	
	public DiceUser() {
		
	}
	
	public DiceUser(int id,String userName,String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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

}
