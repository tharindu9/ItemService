package com.foodcourt.exception;

public class ErrorMassage {
	
	private String massage;
	private String details;
	
	public ErrorMassage(String massage, String details) {
		super();
		this.massage = massage;
		this.details = details;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

}
