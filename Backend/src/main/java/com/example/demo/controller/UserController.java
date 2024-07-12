package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.User;
import com.example.demo.model.response.ApiResponse;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/g")
	public ResponseEntity<String> greet() {
		 return ResponseEntity.ok("Hello from Spring Boot");
	}
	
	@PostMapping("/register")
	public ResponseEntity<ApiResponse<User>> register(@RequestBody User user) {
		System.out.println("user-->   "+user.toString());
		return userService.registerUser(user);
	}
	
	
	
	

}
