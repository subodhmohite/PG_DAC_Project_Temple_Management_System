package com.app.custom_Exceptions;

public class ApiException extends RuntimeException {
	
	public ApiException(String mesg) {
		super(mesg);
	}
}
