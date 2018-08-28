package com.javatpoint.beans;

public class StudentBean {

	private String name,course,branch,email,password;
	private int id,year,phone;
public StudentBean(int id,String name,String course,String branch,int year,int phone,String email, String password) {
		this.id=id;
		this.name=name;
		this.course=course;
		this.branch=branch;
		this.year=year;
		this.phone=phone;
		this.email = email;
		this.password = password;
	}





public String getEmail() {
	return email;
}




public String getName() {
	return name;
}





public void setName(String name) {
	this.name = name;
}





public String getCourse() {
	return course;
}





public void setCourse(String course) {
	this.course = course;
}





public String getBranch() {
	return branch;
}





public void setBranch(String branch) {
	this.branch = branch;
}





public int getId() {
	return id;
}





public void setId(int id) {
	this.id = id;
}





public int getYear() {
	return year;
}





public void setYear(int year) {
	this.year = year;
}





public int getPhone() {
	return phone;
}





public void setPhone(int phone) {
	this.phone = phone;
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




public StudentBean() {}

}