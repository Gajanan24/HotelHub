package com.example.demo.service;

import java.util.Optional;
import java.util.UUID;import javax.swing.ListCellRenderer;

import org.springframework.http.ResponseEntity;

import com.example.demo.data.dto.UserCreationDTO;
import com.example.demo.data.dto.UserDTO;
import com.example.demo.model.entity.User;
import com.example.demo.model.response.ApiResponse;
import java.util.List;

public interface UserService {
	
	public ResponseEntity<ApiResponse<UserDTO>> registerUser(UserCreationDTO user);
	
	public ResponseEntity<ApiResponse<UserDTO>> getUser(UUID userid);
	
	public ResponseEntity<ApiResponse<UserDTO>> updateUser(UUID userId, UserCreationDTO user);
	
	
	public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUsers();
	
	

}
