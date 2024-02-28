package com.example.estate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.estate.dto.UserDTO;
import com.example.estate.service.UserService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
public class UserController {

	@Autowired
	private UserService userService;

	@CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody UserDTO userDTO){
		userService.saveUser(userDTO);
        return new ResponseEntity<>("User saved successfully", HttpStatus.OK);
    }
	
	@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        // Call a service method to check if the provided credentials are valid
        boolean isValidLogin = userService.validateLogin(userDTO.getEmail(), userDTO.getPassword());

        if (isValidLogin) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }
	
}
