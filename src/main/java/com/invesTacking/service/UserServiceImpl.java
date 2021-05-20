package com.invesTacking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invesTacking.dao.UserDao;
import com.invesTacking.model.User;
import com.invesTacking.model.UserDetails;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao repository;
	
	@Override
	public boolean registerUser(User user) {
		
		return repository.registerUser(user) > 0 ? true : false;
	}

	@Override
	public User checkUserLoginUser(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return repository.checkUserLoginUser(userName, userPassword);
	}

	@Override
	public List<UserDetails> getUserDetailsById(int user_Id) {
		// TODO Auto-generated method stub
		return repository.getUserDetailsById(user_Id);
	}

}
