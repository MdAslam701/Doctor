package com.capgemini.bookmydoctor.dto;

public class AdminInfoDto {
	private int adminId;
	private String adminName;
	private int userId;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "AdminInfoDto [adminId=" + adminId + ", adminName=" + adminName + ", userId=" + userId + "]";
	}
	
	

}