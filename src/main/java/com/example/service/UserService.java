package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.UserModel;

public interface UserService {
	
	
	UserModel saveUser(UserModel userModel) throws Exception;
	List<UserModel> getAllUsers();
	Optional<UserModel> getUserById(long id) throws Exception;
	UserModel updateUser(UserModel updatedEmployee) throws Exception;
	void deleteUser(long id) throws Exception;
	
	
	}
