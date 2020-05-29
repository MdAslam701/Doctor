package com.capgemini.bookmydoctor.dto;

import java.sql.Date;

public class PatientHistoryDto {
	private int patientId;
	private int doctorId;
	private int appointmentId;
	Date previousAppointmentDate;
	String treatment;
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Date getPreviousAppointmentDate() {
		return previousAppointmentDate;
	}
	public void setPreviousAppointmentDate(Date previousAppointmentDate) {
		this.previousAppointmentDate = previousAppointmentDate;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
		private int userId;
	@Override
	public String toString() {
		return "PatientHistoryDto [patientId=" + patientId + ", doctorId=" + doctorId + ", appointmentId="
				+ appointmentId + ", previousAppointmentDate=" + previousAppointmentDate + ", treatment=" + treatment
				+ ", userId=" + userId + "]";
	}

}