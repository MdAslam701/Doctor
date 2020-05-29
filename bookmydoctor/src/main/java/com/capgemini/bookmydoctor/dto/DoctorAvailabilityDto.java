package com.capgemini.bookmydoctor.dto;

import java.sql.Date;
import java.sql.Time;

public class DoctorAvailabilityDto {
	private int doctorId;
	private Time fromTime;
	private Time toTime;
	private Date fromDate;
	private Date toDate;
	private String isAvailable;
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public Time getFromTime() {
		return fromTime;
	}
	public void setFromTime(Time fromTime) {
		this.fromTime = fromTime;
	}
	public Time getToTime() {
		return toTime;
	}
	public void setToTime(Time toTime) {
		this.toTime = toTime;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "DoctorAvailabilityDto [doctorId=" + doctorId + ", fromTime=" + fromTime + ", toTime=" + toTime
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", isAvailable=" + isAvailable + "]";
	}
	

}