package com.newcapec.edu.entiy;

import java.util.List;

public class PhoneNum {
	private int phoneNum_id;
	private String name;
	private String num;
	private int user_id;
	private List<PhoneNum> list;  
	public List<PhoneNum> getList() {
		return list;
	}
	public void setList(List<PhoneNum> list) {
		this.list = list;
	}
	public int getPhoneNum_id() {
		return phoneNum_id;
	}
	public void setPhoneNum_id(int phoneNum_id) {
		this.phoneNum_id = phoneNum_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
