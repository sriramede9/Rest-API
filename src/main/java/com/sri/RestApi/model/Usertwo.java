package com.sri.RestApi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "read desc for more details about this entity")
@Entity
public class Usertwo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ApiModelProperty(notes = "should be of minimum 2 charactars")
	@Size(min = 2, message = "name should be minimum of size 2")
	private String name;

	@ApiModelProperty(notes = "date should not be of future value")
	@Past(message = "date should not be of past value")
	@Temporal(TemporalType.DATE)
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

	
	public Usertwo(@Size(min = 2, message = "name should be minimum of size 2") String name,
			@Past(message = "date should not be of past value") Date dob) {
		super();
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
