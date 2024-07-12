package com.example.demo.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.example.demo.data.dto.UserCreationDTO;
import com.example.demo.data.dto.UserDTO;
import com.example.demo.model.entity.User;
import com.example.demo.model.response.ApiResponse;

public interface UserService {
	
	public ResponseEntity<ApiResponse<UserDTO>> registerUser(UserCreationDTO user);
	
	public ResponseEntity<ApiResponse<UserDTO>> getUser(UUID userid);
	
	
	

}
