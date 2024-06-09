package com.example.estate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartCode;
	
	@ManyToOne
	@JoinColumn(name = "userCode")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "productCode")
	private Product product;
	
	@Column
    private String cartSize; // 사이즈

    @Column
    private String cartColor; // 색상
    
	@Column
	private int productCount;
}
