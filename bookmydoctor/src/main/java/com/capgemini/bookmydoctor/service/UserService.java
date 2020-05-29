package com.capgemini.bookmydoctor.service;

import com.capgemini.bookmydoctor.dto.UserInfoDto;

public interface UserService {
	
	public void addUser(UserInfoDto userInfo);
	
	public void updateUser(String password, int userId);
	
	public UserInfoDto getUser(int id);

}