package com.capgemini.bookmydoctor.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.bookmydoctor.dto.AppointmentInfoDto;
import com.capgemini.bookmydoctor.dto.DoctorAvailabilityDto;
import com.capgemini.bookmydoctor.dto.DoctorInfoDto;
import com.capgemini.bookmydoctor.dto.FeedbackDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientHistoryDto;
import com.capgemini.bookmydoctor.dto.PatientInfoDto;

public interface PatientService {
	
	public void bookAppointment(AppointmentInfoDto infoDto);
	
	public void writeReview(FeedbackDetailsDto detailsDto);
	
	public List<FeedbackDetailsDto> viewFeedback(FeedbackDetailsDto f);

	public PatientHistoryDto viewPatientHistory(int patientId1);
	
	public AppointmentInfoDto viewAppointmentHistory(int patientId);
	
	public DoctorAvailabilityDto viewDoctorAvailabity(int doctorId);
	
	public DoctorInfoDto viewDoctorInfo(String speciality);

	public void addPatientInfo(PatientInfoDto patientInfoDto);

	

	
	
	

}