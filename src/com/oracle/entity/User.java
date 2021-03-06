package com.oracle.entity;

import java.util.Date;

public class User {
	private String name;
	private String pwd;
	private Date birth;
	public User(){
		
	}
	public User(String name,Date birth){
		this.birth=birth;
		this.name=name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", pwd=" + pwd + ", birth=" + birth + "]";
	}
	
	
}
