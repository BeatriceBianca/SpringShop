package com.mds.springshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS1")
public class Users implements Serializable {
	private static final long serialVersionUID = -2054386655979281969L;
	
	private int user_id;
	private String last_name;
	private String first_name;
	private String email;
	private String password;
	private String role;
	private int phone;
	private String address;
	
    @Id
    @Column(name = "ids")
	public int getUser_id() {
		return user_id;
	}
    
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	@Column(name="last_name")
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	@Column(name="first_name")
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="passwords")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="user_role")
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(name="phone")
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}