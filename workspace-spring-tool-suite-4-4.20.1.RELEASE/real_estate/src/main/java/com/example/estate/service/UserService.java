package com.example.estate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.estate.entity.Product;
import com.example.estate.entity.User;
import com.example.estate.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
    UserRepository userRepository;
    
	 @Transactional
	 public void saveUser(User user) {
	     user.setEmail(user.getEmail());
	     user.setPassword(user.getPassword());
	     user.setName(user.getName());
	     user.setPhoneNumber(user.getPhoneNumber());
	     user.setAddress(user.getAddress());
	     user.setBirth(user.getBirth());

	     userRepository.save(user);
	 }
	 
	 @Transactional(readOnly = true)
	 public User findByEmail(String email) {
	     return userRepository.findByEmail(email);
	 }

	 @Transactional
	 public boolean validateLogin(String email, String password) {
	     // Retrieve the user by email from the database
	     User user = userRepository.findByEmail(email);

	     // Check if the user exists and if the password matches
	     return user != null && user.getPassword().equals(password);
	 }
	 
	 @Transactional(readOnly = true)
	    public User findByUserCode(Long UserCode) {
	        return userRepository.findByUserCode(UserCode);
	    }
}