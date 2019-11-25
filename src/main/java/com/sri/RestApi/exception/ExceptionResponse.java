package com.sri.RestApi.exception;

import java.util.Date;

//so every exception has date timestamp and details

public class ExceptionResponse {

	// creating a custom structure
	// timestamp
	// message
	// details

	private Date timestamp;
	private String Message;
	private String detail;

	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionResponse(Date timestamp, String message, String detail) {
		super();
		this.timestamp = timestamp;
		Message = message;
		this.detail = detail;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [timestamp=" + timestamp + ", Message=" + Message + ", detail=" + detail + "]";
	}

}
