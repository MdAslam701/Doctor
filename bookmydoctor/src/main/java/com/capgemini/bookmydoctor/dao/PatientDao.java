package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.bookmydoctor.dto.AppointmentInfoDto;
import com.capgemini.bookmydoctor.dto.DoctorAvailabilityDto;
import com.capgemini.bookmydoctor.dto.DoctorInfoDto;
import com.capgemini.bookmydoctor.dto.FeedbackDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientHistoryDto;
import com.capgemini.bookmydoctor.dto.PatientInfoDto;

public interface PatientDao {


	
	
	public void writeReviewJDBC(FeedbackDetailsDto detailsDto);
	
	public PatientHistoryDto viewPatientHistoryJDBC(int patientId);
	
	public AppointmentInfoDto viewAppointmentInfoJDBC(int patientId);

	public DoctorInfoDto viewDoctorInfoJDBC(String speciality);

	public List<FeedbackDetailsDto> viewFeedbackDetailsJDBC(FeedbackDetailsDto f);

	public void bookAppointmentJDBC(AppointmentInfoDto infoDto);

	DoctorAvailabilityDto viewDoctorAvailabilityJDBC(int doctorId);

	public void addPatientInfoJDBC(PatientInfoDto patientInfo);




	

}