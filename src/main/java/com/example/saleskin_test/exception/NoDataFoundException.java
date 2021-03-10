package com.example.saleskin_test.exception;

public class NoDataFoundException extends Exception {

	private String message;

	public NoDataFoundException(String message) {
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
