package com.capgemini.bookmydoctor.dto;

public class DoctorInfoDto {

	private int doctorId;
	private String doctorName;
	private String speciaity;
	private String location;
	private String address;
	private long visitingFees;
	private int userId;
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpeciaity() {
		return speciaity;
	}
	public void setSpeciaity(String speciaity) {
		this.speciaity = speciaity;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getVisitingFees() {
		return visitingFees;
	}
	public void setVisitingFees(long visitingFees) {
		this.visitingFees = visitingFees;
	}
	
	@Override
	public String toString() {
		return "DoctorInfoDto [doctorId=" + doctorId + ", doctorName=" + doctorName + ", speciaity=" + speciaity
				+ ", location=" + location + ", address=" + address + ", visitingFees=" + visitingFees + ", userId="
				+ userId + "]";
	}
	
}