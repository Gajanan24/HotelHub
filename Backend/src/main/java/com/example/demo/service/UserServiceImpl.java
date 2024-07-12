package com.example.demo.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.UserCreationDTO;
import com.example.demo.data.dto.UserDTO;
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
	public ResponseEntity<ApiResponse<UserDTO>> registerUser(UserCreationDTO userdto) {
		 User user = new User();
		    user.setEmail(userdto.getEmail());
		    user.setFirstName(userdto.getFirstName());
		    user.setLastName(userdto.getLastName());
		    user.setPhoneNumber(userdto.getPhoneNumber());
		    user.setPassword(userdto.getPassword());
		    user.setNationality(userdto.getNationality());
		    
		    
		User savedUser =  userRepository.save(user);
		
		UserDTO userDTO2 = new UserDTO();
		userDTO2.setUserId(savedUser.getUserId());
		userDTO2.setEmail(savedUser.getEmail());
		userDTO2.setFirstName(savedUser.getFirstName());
		userDTO2.setLastName(savedUser.getLastName());
		userDTO2.setNationality(savedUser.getNationality());
		userDTO2.setPhoneNumber(savedUser.getPhoneNumber());
		
		
		return responseBuilder.buildResponse(HttpStatus.CREATED.value(), "User saved successfully", userDTO2);
	}


	@Override
	public ResponseEntity<ApiResponse<UserDTO>> getUser(UUID userid) {
		
			Optional<User> opUser =  userRepository.findById(userid);
			
			if(opUser.isEmpty()) {
				
				throw new ResourceNotFoundException("Canot find User with Id: "+userid);
				
			}
			User user = opUser.get();
			UserDTO userDTO2 = new UserDTO();
			userDTO2.setUserId(user.getUserId());
			userDTO2.setEmail(user.getEmail());
			userDTO2.setFirstName(user.getFirstName());
			userDTO2.setLastName(user.getLastName());
			userDTO2.setNationality(user.getNationality());
			userDTO2.setPhoneNumber(user.getPhoneNumber());
			return responseBuilder.buildResponse(HttpStatus.OK.value(),"User Data",userDTO2);
		
		
	}

}
