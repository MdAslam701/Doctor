package com.capgemini.bookmydoctor.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AdminController {
	
	static Logger log = LogManager.getLogger(PatientController.class);
	static Scanner sc = new Scanner(System.in);

	public void display() {
		System.out.println("Admin is selected");
		
		log.info("How can we help you?" + "\n" + "Enter your choice");
		log.info("1 to view admin info\r\n" + "	\r\n" + "2 to view appointment info\r\n" + "	\r\n"
				+ "3 to view doctor availability\r\n" + "	\r\n" + "4 to view doctor info\r\n" + "	\r\n"
				+ "5 to view feedback details\r\n" + "\r\n" + "6 to view patient history\r\n"
				+ "\r\n" + "7 to view patient info");
		
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1 :
		case 2 :
		case 3 :
		case 4 :
		case 5 :
		case 6 :
		case 7 :
		}
	}
}