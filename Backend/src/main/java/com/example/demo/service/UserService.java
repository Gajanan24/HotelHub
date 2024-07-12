package com.example.demo.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.entity.User;
import com.example.demo.model.response.ApiResponse;

public interface UserService {
	
	public ResponseEntity<ApiResponse<User>> registerUser(User user);
	
	public ResponseEntity<ApiResponse<User>> getUser(Integer userid);
	
	
	

}
