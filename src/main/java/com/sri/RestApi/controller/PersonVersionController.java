package com.sri.RestApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.RestApi.versioning.Name;
import com.sri.RestApi.versioning.Personv1;
import com.sri.RestApi.versioning.Personv2;

@RestController
public class PersonVersionController {

	@GetMapping("/personv1")
	public Personv1 getv1() {
		return new Personv1("jaffa boy");
	}

	@GetMapping("/personv2")
	public Personv2 getv2() {
		return new Personv2(new Name("jaffa", " boy"));
	}
	
	
	//handling by param
	
	//http://localhost:8084/person/param?version=1
	//http://localhost:8084/person/param?version=2
	
	@GetMapping(value="/person/param",params = "version=1")
	public Personv1 getv1byParam() {
		return new Personv1("jaffa boy");
	}
	
	@GetMapping(value="/person/param",params = "version=2")
	public Personv2 getv2byParam() {
		return new Personv2(new Name("jaffa", " boy")); 
	}
	
	
	//by Header Param
	
	//set headers before callig by postman so that user can get values based on that.
	
	@GetMapping(value="/person/header",headers = "X_API_version=1")
	public Personv1 getv1byHeaderParam() {
		return new Personv1("jaffa boy");
	}
	
	@GetMapping(value="/person/header",headers = "X_API_version=2")
	public Personv2 getv2byHeaderParam() {
		return new Personv2(new Name("jaffa", " boy")); 
	}
	
	
	
	//by headerparam
	@GetMapping(value="/person/produces",produces = "application/vnd.company.app-v1+json")
	public Personv1 getv1byProduces() {
		return new Personv1("jaffa boy");
	}
	
	@GetMapping(value="/person/produces",produces = "application/vnd.company.app-v2+json")
	public Personv2 getv2byProduces() {
		return new Personv2(new Name("jaffa", " boy")); 
	}
	
	
	
}
