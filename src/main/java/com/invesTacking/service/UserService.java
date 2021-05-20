package com.invesTacking.service;

import java.util.List;

import com.invesTacking.model.User;
import com.invesTacking.model.UserDetails;

public interface UserService {

	public boolean registerUser(User user);
	
	public User checkUserLoginUser(String userName, String userPassword);
	
	public List<UserDetails> getUserDetailsById(int user_Id);


}
