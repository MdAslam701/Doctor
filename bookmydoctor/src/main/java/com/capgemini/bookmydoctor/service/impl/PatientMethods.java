package com.capgemini.bookmydoctor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.bookmydoctor.controller.MainController;
import com.capgemini.bookmydoctor.dao.*;
import com.capgemini.bookmydoctor.dao.impl.PatientDaoImpl;
import com.capgemini.bookmydoctor.dto.AppointmentInfoDto;
import com.capgemini.bookmydoctor.dto.DoctorAvailabilityDto;
import com.capgemini.bookmydoctor.dto.DoctorInfoDto;
import com.capgemini.bookmydoctor.dto.FeedbackDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientHistoryDto;
import com.capgemini.bookmydoctor.dto.PatientInfoDto;
import com.capgemini.bookmydoctor.service.PatientService;

public class PatientMethods implements PatientService {

	static Logger log = LogManager.getLogger(MainController.class);

	public void addPatientInfo(PatientInfoDto patientInfo) {
		PatientDao dao = new PatientDaoImpl();
		dao.addPatientInfoJDBC(patientInfo);

	}

	public void bookAppointment(AppointmentInfoDto infoDto) {
		PatientDao dao = new PatientDaoImpl();
		dao.bookAppointmentJDBC(infoDto);

	}

	@Override
	public void writeReview(FeedbackDetailsDto detailsDto) {
		PatientDao dao = new PatientDaoImpl();

		dao.writeReviewJDBC(detailsDto);

	}

	public List<FeedbackDetailsDto> viewFeedback(FeedbackDetailsDto f) {
		PatientDao dao = new PatientDaoImpl();

		return dao.viewFeedbackDetailsJDBC(f);
	}

	public PatientHistoryDto viewPatientHistory(int patientId) {
		PatientDao dao = new PatientDaoImpl();

		PatientHistoryDto patientHistoryDto = dao.viewPatientHistoryJDBC(patientId);
		return patientHistoryDto;
	}

	public AppointmentInfoDto viewAppointmentHistory(int patientId) {
		PatientDao dao = new PatientDaoImpl();

		AppointmentInfoDto appointmentInfoDto = dao.viewAppointmentInfoJDBC(patientId);
		return appointmentInfoDto;
	}

	@Override
	public DoctorAvailabilityDto viewDoctorAvailabity(int doctorId) {
		PatientDao dao = new PatientDaoImpl();

		DoctorAvailabilityDto doctorAvailabilityDto = dao.viewDoctorAvailabilityJDBC(doctorId);
		return doctorAvailabilityDto;
	}

	@Override
	public DoctorInfoDto viewDoctorInfo(String speciality) {
		PatientDao dao = new PatientDaoImpl();

		DoctorInfoDto docInfo = dao.viewDoctorInfoJDBC(speciality);

		return docInfo;

	}

}