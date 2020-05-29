package com.capgemini.bookmydoctor.exception;

public class PatientIdNotFoundException extends RuntimeException{
	String msg = "Patient ID is not present";

	public PatientIdNotFoundException() {
		super();
	}

	@Override
	public String getMessage() {
		return this.msg;
	}

}
