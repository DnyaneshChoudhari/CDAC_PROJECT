package com.app.custom_exception;

public class CustomException extends RuntimeException{
	public CustomException(String mesg) {
		super(mesg);
	}
}
