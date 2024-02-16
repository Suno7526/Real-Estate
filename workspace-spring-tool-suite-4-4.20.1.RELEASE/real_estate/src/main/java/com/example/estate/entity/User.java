package com.example.estate.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userCode;
	
	@Column(nullable = false, length = 45, unique = true)
	private String userId;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(nullable = false, length = 50)
	private String phoneNumber;
	
	@Column(nullable = false, length = 300)
	private String address;
	
	@CreationTimestamp
	private Timestamp createDate;
}