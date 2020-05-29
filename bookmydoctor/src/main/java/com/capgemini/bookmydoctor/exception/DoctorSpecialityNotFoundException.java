package com.capgemini.bookmydoctor.exception;

public class DoctorSpecialityNotFoundException extends RuntimeException{
	String msg = "This doctor speciality is not present";

	public DoctorSpecialityNotFoundException() {
		super();
	}

	@Override
	public String getMessage() {
		return this.msg;
	}

}
