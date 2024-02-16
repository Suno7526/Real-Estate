package com.example.estate.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productCode;
	
	@ManyToOne
	@JoinColumn(name = "userCode")
	private User user;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false, length = 200)
	private String address;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(nullable = false)
	private double area;
	
	@Column(nullable = false)
	private int room;
	
	@Column(nullable = false)
	private String transactionType;
	
	@Column(nullable = false)
	private int price;
	
	@Column(nullable = false)
	private int cost;
	
	@Column
	private Timestamp moveDate;
	
	@Column(nullable = false)
	private int floor;
	
	@Column(nullable = false)
	private int bathroom;
	
	@Column(nullable = false)
	private int parking;
	
	@Column
	private String options;
	
	@Column
	private String image;
	
	@Column
	private String infomation;
	
	@Column
	private Timestamp createDate;

	@Column
	private Timestamp updatedDate;
	
	@Column
	private Timestamp deletionDate;

}
