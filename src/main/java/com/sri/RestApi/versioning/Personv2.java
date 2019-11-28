package com.sri.RestApi.versioning;

public class Personv2 {

	private Name name;

	public Personv2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personv2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Personv2 [name=" + name + "]";
	}
	
	
	
}
