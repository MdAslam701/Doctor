package com.capgemini.bookmydoctor.exception;

public class AppoinmentCannotBookedException extends RuntimeException{

	String msg = "Sorry.. This appointment cannot be booked";

	public AppoinmentCannotBookedException() {
		super();
	}

	@Override
	public String getMessage() {
		return this.msg;
	}
}
