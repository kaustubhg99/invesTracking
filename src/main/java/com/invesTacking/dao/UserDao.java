package com.invesTacking.dao;

import java.util.List;

import com.invesTacking.model.User;
import com.invesTacking.model.UserDetails;

public interface UserDao {
	
	public int registerUser(User user);
	
	public User checkUserLoginUser(String userName, String userPassword);
	
	public List<UserDetails> getUserDetailsById(int user_Id);

}

