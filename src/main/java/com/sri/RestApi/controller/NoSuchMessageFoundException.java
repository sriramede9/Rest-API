package com.sri.RestApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchMessageFoundException extends RuntimeException {

	public NoSuchMessageFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
