package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.User;
import com.example.demo.model.response.ApiResponse;
import com.example.demo.model.response.ResponseBuilder;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	public UserRepository userRepository;
	
	 @Autowired
	 private ResponseBuilder responseBuilder;
	

	@Override
	public ResponseEntity<ApiResponse<User>> registerUser(User user) {
		User savedUser =  userRepository.save(user);
		System.out.println("saved user"+savedUser);
		return responseBuilder.buildResponse(HttpStatus.CREATED.value(), "User saved successfully", savedUser);
	}


	@Override
	public ResponseEntity<ApiResponse<User>> getUser(Integer userid) {
		
			Optional<User> opUser =  userRepository.findById(userid);
			
			if(opUser.isPresent()) {
				
				throw new ResourceNotFoundException("Canot find User with Id: "+userid);
				
			}
			User user = opUser.get();
			return responseBuilder.buildResponse(HttpStatus.OK.value(),"User Data",user);
		
		
	}

}
