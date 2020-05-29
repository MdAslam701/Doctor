package com.capgemini.bookmydoctor.factory;


import com.capgemini.bookmydoctor.service.impl.PatientMethods;
import com.capgemini.bookmydoctor.service.PatientService;
import com.capgemini.bookmydoctor.service.impl.UserSerImpl;
import com.capgemini.bookmydoctor.service.UserService;

public class UserFactory {
	
	
	
	public UserService getUserObj() {
		UserService userService = new UserSerImpl();
		return userService;
		
	}
	public PatientService getObject() {
		PatientService	patientService = new PatientMethods();
		return patientService;
	}

}