package com.foodcourt.controller;

public class NullValueException extends RuntimeException {
	
	private String ExceptionMessage;

	public NullValueException(String exceptionMessage) {
		ExceptionMessage = exceptionMessage;
	}

	public String getExceptionMessage() {
		return ExceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		ExceptionMessage = exceptionMessage;
	}
	
	
	
}
