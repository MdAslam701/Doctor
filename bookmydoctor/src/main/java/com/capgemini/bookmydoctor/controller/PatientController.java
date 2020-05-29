package com.capgemini.bookmydoctor.controller;

import java.util.Scanner;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import com.capgemini.bookmydoctor.dto.AppointmentInfoDto;
import com.capgemini.bookmydoctor.dto.DoctorAvailabilityDto;
import com.capgemini.bookmydoctor.dto.DoctorInfoDto;
import com.capgemini.bookmydoctor.dto.FeedbackDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientHistoryDto;
import com.capgemini.bookmydoctor.dto.PatientInfoDto;
import com.capgemini.bookmydoctor.dto.UserInfoDto;
import com.capgemini.bookmydoctor.exception.AppoinmentCannotBookedException;
import com.capgemini.bookmydoctor.exception.InvalidEntryException;
import com.capgemini.bookmydoctor.exception.PatientIdNotFoundException;
import com.capgemini.bookmydoctor.factory.UserFactory;
import com.capgemini.bookmydoctor.service.PatientService;
import com.capgemini.bookmydoctor.service.UserService;

public class PatientController {
	static Logger log = LogManager.getLogger(PatientController.class);
	static Scanner sc = new Scanner(System.in);
	PatientInfoDto patientInfoDto = new PatientInfoDto();
	UserInfoDto userInfoDto = new UserInfoDto();
	FeedbackDetailsDto feedbackDetailsDto = new FeedbackDetailsDto();
	 UserFactory userFactory = new UserFactory();
	 PatientService service = userFactory.getObject();

	public void enterChoice() {
		log.info("----------------------------------------");
		log.info("Press 1.To LogIn\nIf new User Press\n2.To SignUp ");
		log.info("----------------------------------------");

		int choice = sc.nextInt();
		if (choice == 1) {
			patientLogIn();
		} else if (choice == 2) {
			log.info("Enter Details");
			UserController userController = new UserController();
			int id = userController.signUp();
			patientSingUp(id);
		} else {
			throw new InvalidEntryException();
		}
	}

	public void writeReview() {
		FeedbackDetailsDto detailsDto = new FeedbackDetailsDto();
		log.info("enter patient id");
		int patientId = sc.nextInt();
		detailsDto.setPatientId(patientId);
		log.info("enter doctor id");
		int doctorId = sc.nextInt();
		detailsDto.setDoctorId(doctorId);
		log.info("enter rating");
		String rating = sc.next();
		detailsDto.setRating(rating);
		UserFactory userFactory = new UserFactory();
		PatientService service = userFactory.getObject();
		service.writeReview(detailsDto);

	}

	public void bookAppointment() {
		try {

			AppointmentInfoDto infoDto = new AppointmentInfoDto();
			log.info("enter patient id");
			int patientId = sc.nextInt();
			infoDto.setPatientId(patientId);
			log.info("enter doctor id");
			int doctorId = sc.nextInt();
			infoDto.setDoctorId(doctorId);
			log.info("enter date in yyyy-mm-dd");
			String d1 = sc.next();
			infoDto.setDate(Date.valueOf(d1));
			System.out.println("date entered");
			log.info("enter time in hh:mm:ss");
			String d2 = sc.next();
			infoDto.setTime(Time.valueOf(d2));
			
			UserFactory userFactory = new UserFactory();
			PatientService service = userFactory.getObject();
			service.bookAppointment(infoDto);
		} catch (Exception e) {
			throw new AppoinmentCannotBookedException();
		}

	}

	public void patientSingUp(int patientId) {
		PatientInfoDto patientInfoDto = new PatientInfoDto();
		patientInfoDto.setPatientId(patientId);
		log.info("Enter patient name");
		String patientName = sc.next();
		sc.nextLine();
		patientInfoDto.setPatientName(patientName);
		log.info("Enter Disease");
		String disease = sc.next();
		sc.nextLine();
		patientInfoDto.setDisease(disease);
		log.info("Enter secondary phone number");
		long secPhoneNo = sc.nextLong();
		patientInfoDto.setSecPhoneNo(secPhoneNo);

		patientInfoDto.setUserId(patientId);
		

		 UserFactory userFactory = new UserFactory();
		 PatientService service = userFactory.getObject();
		service.addPatientInfo(patientInfoDto);

		log.info("Registration Completed");
		while (true) {
			log.info("Press 1.To LogIn\nPress 2.To Home ");
			try {
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					patientLogIn();
					break;

				case 2:
					MainController.user();
					break;

				default:
					log.info("Invalid Valid Entry");
					break;
				}
				
			}catch(Exception e) {
				throw new InvalidEntryException();
			}
			
		}
	}

	public void patientLogIn() {
		log.info("----------------------------------------");
		log.info("Welcome to login page");
		log.info("----------------------------------------");
		log.info("Enter the LogIN id");
		int id = sc.nextInt();

		

		log.info("Enter the password");
		String password = sc.next();
		UserFactory factory = new UserFactory();
		UserService Service = factory.getUserObj();
		UserInfoDto user1 = Service.getUser(id);
		if (id == user1.getUserId() && password.equals(user1.getPassword())) {
			while (true) {
				log.info("LOG IN SUCCESSFULL");
				log.info("login successful");
				log.info("How can we help you?" + "\n" + "Enter your choice");
				log.info("1 for Booking a new appointment\r\n" + "	\r\n" + "2 for writing a review\r\n" + "	\r\n"
						+ "3 for viewing a feedback\r\n" + "	\r\n" + "4 for viewing patient history\r\n" + "	\r\n"
						+ "5 for viewing appointment history\r\n" + "\r\n"
						+ "6 for checking availability of doctors\r\n" + "\r\n" + "7 for viewing doctor information\r\n"
						+ "\r\n" + "8 to logout");

				try {
				int choice1 = sc.nextInt();

				List<FeedbackDetailsDto> list;
				switch (choice1) {
				case 1:
					log.info("book....");
					log.info("Enter speciality");
					String speciality = sc.next();
					DoctorInfoDto doc1 = service.viewDoctorInfo(speciality);
					log.info("view availability of doctors");
					log.info("Enter doctor id");
					int doctorId = sc.nextInt();
					DoctorAvailabilityDto doc2 = service.viewDoctorAvailabity(doctorId);
					log.info(doc2);
					log.info(doc1);
					bookAppointment();

					break;
				case 2:
					log.info("write...");
					writeReview();

					break;
				case 3:
					service = userFactory.getObject();
					List<FeedbackDetailsDto> list1 = service.viewFeedback(feedbackDetailsDto);
					Iterator itr = list1.iterator();
					while(itr.hasNext()) {
						System.out.println(itr.next());
					}
					break;
				case 4:
					log.info("Enter patient id");
					int patientId1 = sc.nextInt();
					PatientHistoryDto doc4 = service.viewPatientHistory(patientId1);
					log.info(doc4);
					break;
				case 5:
					log.info("Enter patient id");
					int patientId = sc.nextInt();
					AppointmentInfoDto doc3 = service.viewAppointmentHistory(patientId);
					log.info(doc3);

					break;
				case 6:

					log.info("Enter doctor id");
					int doctorId3 = sc.nextInt();
					DoctorAvailabilityDto doc22 = service.viewDoctorAvailabity(doctorId3);
					log.info(doc22);
					break;
				case 7:

					log.info("Enter speciality");
					String speciality1 = sc.next();
					DoctorInfoDto doc11 = service.viewDoctorInfo(speciality1);
					log.info(doc11);
					break;
					
				case 8:
					MainController.user();
					break;
				default:
					log.info("Invalid choice");
				}

			}catch(Exception e) {
				throw new InvalidEntryException();
			}
			}
		}else {
			throw new PatientIdNotFoundException();
		}
	}//end of login
}//end of class