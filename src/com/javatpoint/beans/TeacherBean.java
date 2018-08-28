package com.javatpoint.beans;

public class TeacherBean {
	private int id;
	private String name,sub,email,password,address;
	

public TeacherBean() {}

public TeacherBean(int id, String name, String sub, String email,
		String password, String address) {

	this.id = id;
	this.name = name;
	this.sub = sub;
	this.email = email;
	this.password = password;
	this.address = address;
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


public String getSub() {
	return sub;
}


public void setSub(String sub) {
	this.sub = sub;
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


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


}

