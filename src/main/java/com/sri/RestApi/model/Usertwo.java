package com.sri.RestApi.model;

import java.util.Date;

public class Usertwo {

	private int id;
	private String name;
	private Date dob;

	public Usertwo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usertwo(int id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Usertwo [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}

}
