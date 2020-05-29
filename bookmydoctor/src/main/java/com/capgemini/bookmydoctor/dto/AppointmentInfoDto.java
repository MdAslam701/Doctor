package com.capgemini.bookmydoctor.dto;

import java.sql.Date;
import java.sql.Time;

public class AppointmentInfoDto {

	private int appointmentId;
	private int patientId;
	private int doctorId;
	private Date date;
	private Time time;
	private String status;

	

	

	

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

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

	public String getStatus() {
		return status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AppointmentInfoDto [appointmentId=" + appointmentId + ", patientId=" + patientId + ", doctorId="
				+ doctorId + ", date=" + date + ", time=" + time + ", status=" + status + "]";
	}

}