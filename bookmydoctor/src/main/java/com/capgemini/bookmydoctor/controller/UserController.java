package com.capgemini.bookmydoctor.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.bookmydoctor.dto.UserInfoDto;
import com.capgemini.bookmydoctor.factory.UserFactory;
import com.capgemini.bookmydoctor.service.UserService;

public class UserController {

	Scanner sc = new Scanner(System.in);
	Logger log = LogManager.getLogger("user");
	UserInfoDto userInfo = new UserInfoDto();

	
	public int signUp() {
		log.info("Enter User Id");
		int userId = sc.nextInt();
		userInfo.setUserId(userId);
		log.info("Enter user Type");
		String type = sc.next();
		sc.nextLine();
		userInfo.setUserType(type);

		log.info("Enter the password");
		
		String password = sc.next();
		
		userInfo.setPassword(password);

		log.info("enter primary phone number");
		long phone = sc.nextLong();
		userInfo.setPrimaryPhoneNo(phone);

		System.out.println("Enter your Email: ");
		String emailId = sc.next();
		userInfo.setEmailId(emailId);

		log.info("Enter gender");
		String gender = sc.next();
		sc.nextLine();
		userInfo.setGender(gender);

		UserFactory userFactory = new UserFactory();
		UserService service = userFactory.getUserObj();
		
		service.addUser(userInfo);

		return userInfo.getUserId();

	}

	public void updateUser(int id) {
		String password = sc.next();
		sc.nextLine();

		UserFactory userFactory = new UserFactory();
		UserService service = userFactory.getUserObj();
		service.updateUser(password, id);

	}

}