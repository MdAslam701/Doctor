package com.capgemini.bookmydoctor.dto;

public class PatientInfoDto {
	private int patientId;
	private String patientName;
	private String disease;
	private long secPhoneNo;
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public long getSecPhoneNo() {
		return secPhoneNo;
	}
	public void setSecPhoneNo(long secPhoneNo) {
		this.secPhoneNo = secPhoneNo;
	}
	
	@Override
	public String toString() {
		return "PatientInfoDto [patientId=" + patientId + ", patientName=" + patientName + ", disease=" + disease
				+ ", secPhoneNo=" + secPhoneNo + "]";
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public void setUserId(int patientId2) {
		// TODO Auto-generated method stub
		
	}
	

}