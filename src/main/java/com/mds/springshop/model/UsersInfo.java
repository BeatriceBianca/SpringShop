package com.mds.springshop.model;

import com.mds.springshop.entity.Users;

public class UsersInfo {
	private int user_id;
	private String lastName;
	private String firstName;
	private String email;
	private String password;
	private String role;
	private int phone;
	private String address;
	private boolean newUser=false;
	public UsersInfo(){
		
	}
	public UsersInfo(Users user)
	{
		this.firstName=user.getFirstName();
		this.lastName=user.getLastName();
		this.email=user.getAddress();
		this.phone=user.getPhone();
		this.password=user.getPassword();
		this.address=user.getAddress();
	}
	public UsersInfo(String lastName,String firstName,String email,String password,int phone,String address)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.phone=phone;
		this.password=password;
		this.address=address;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	 public boolean isNewUser() {
	        return newUser;
	    }
	 public void setNewUser(boolean newUser) {
	        this.newUser = newUser;
	    }
	 
}
