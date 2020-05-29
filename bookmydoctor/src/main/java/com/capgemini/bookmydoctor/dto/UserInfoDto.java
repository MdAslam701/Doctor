package com.capgemini.bookmydoctor.dto;

public class UserInfoDto {

	private int userId;
	private String userType;
	private String password;
	private long primaryPhoneNo;
	private String emailId;
	private String gender;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPrimaryPhoneNo() {
		return primaryPhoneNo;
	}
	public void setPrimaryPhoneNo(long primaryPhoneNo) {
		this.primaryPhoneNo = primaryPhoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "AdminInfoDto [userId=" + userId + ", userType=" + userType + ", password=" + password
				+ ", primaryPhoneNo=" + primaryPhoneNo + ", emailId=" + emailId + ", gender=" + gender + "]";
	}
	
}