package com.capgemini.bookmydoctor.exception;

public class DoctorIdNotFoundException extends RuntimeException{
	String msg = "DoctorId is not present";

	public DoctorIdNotFoundException() {
		super();
	}

	@Override
	public String getMessage() {
		return this.msg;
	}

}
