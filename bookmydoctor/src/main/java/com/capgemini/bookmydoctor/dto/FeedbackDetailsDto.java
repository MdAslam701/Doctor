package com.capgemini.bookmydoctor.dto;

public class FeedbackDetailsDto {
	private int feedbackId;
	private int patientId;
	private int doctorId;
	private String rating;
	
		
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	

	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
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
	@Override
	public String toString() {
		return " [feedbackId=" + feedbackId + ", patientId=" + patientId + ", doctorId=" + doctorId
				+ ", rating=" + rating + "]" +"\n";
	}

}