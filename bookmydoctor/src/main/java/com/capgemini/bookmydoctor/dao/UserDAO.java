package com.capgemini.bookmydoctor.dao;


import com.capgemini.bookmydoctor.dto.UserInfoDto;

public interface UserDAO {
	
	public void insertUser( UserInfoDto userInfo);

	public void updateUser(String password, int userId);

	public UserInfoDto getUser(int id);

	
	
	
	
}