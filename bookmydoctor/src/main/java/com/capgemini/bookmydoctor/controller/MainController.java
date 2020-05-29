package com.capgemini.bookmydoctor.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.bookmydoctor.exception.InvalidEntryException;

public class MainController {

	static Logger log = LogManager.getLogger(MainController.class);
	static Scanner sc = new Scanner(System.in);

	public static void user() {
		log.info("----------------------------------------");
		log.info("WELCOME TO BOOK MY DOCTOR APPLICATION");
		log.info("Press 1.Admin\nPress 2.Doctor\nPress 3.Patient\nPress 4.Exit");
		log.info("----------------------------------------");
		log.info("Enter your choice");
		try {
			int choice = sc.nextInt();

			switch (choice) {
			case 1:

				break;

			case 2:
				DoctorController doctorController = new DoctorController();
				break;

			case 3:
				PatientController patientController = new PatientController();
				patientController.enterChoice();

				break;

			case 4:
				System.exit(0);

			default:
				log.error("Invalid Choice");

			}
		} catch (Exception e) {
			throw new InvalidEntryException();
		}
	}

	public static void main(String[] args) {

		log.info("----------------------------------------");
		log.info("WELCOME TO BOOK MY DOCTOR APPLICATION");
		log.info("Press 1.Admin\nPress 2.Doctor\nPress 3.Patient\nPress 4.Home\nPress 5.Exit");
		log.info("----------------------------------------");
		log.info("Enter your choice");
		int choice = 0;
		try {
			choice = sc.nextInt();
		} catch (Exception e) {
			throw new InvalidEntryException();
		}
		switch (choice) {
		case 1:
			break;

		case 2:
			// DoctorController doctorController = new DoctorController();
			// doctorController.enterChoice();
			// break;

		case 3:
			PatientController patientController = new PatientController();
			patientController.enterChoice();

			break;
		case 4:
			user();
			break;
		case 5:
			System.exit(0);

		default:
			log.error("Invalid Choice");

		}

	}

}