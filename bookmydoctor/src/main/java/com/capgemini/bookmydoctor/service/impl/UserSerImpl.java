package com.capgemini.bookmydoctor.service.impl;

import com.capgemini.bookmydoctor.dao.UserDAO;
import com.capgemini.bookmydoctor.dao.impl.UserDAOImpl;
import com.capgemini.bookmydoctor.dto.UserInfoDto;
import com.capgemini.bookmydoctor.service.UserService;

public class UserSerImpl implements UserService{
	UserDAO user = new UserDAOImpl();

	@Override
	public void addUser(UserInfoDto userInfo) {
		user.insertUser(userInfo);
		
	}

	@Override
	public void updateUser(String password, int userId) {
		user.updateUser(password, userId);
		
	}

	@Override
	public UserInfoDto getUser(int id) {
		UserInfoDto userInfo = user.getUser(id);
		return userInfo;
	}

}