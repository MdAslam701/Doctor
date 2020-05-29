package com.capgemini.bookmydoctor.exception;

public class InvalidEntryException extends RuntimeException{

	String msg = "Please enter valid choice";

	public InvalidEntryException() {
		super();
	}

	@Override
	public String getMessage() {
		return this.msg;
	}
}
