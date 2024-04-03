package com.example.estate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.estate.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	Cart findByCartCode(Long CartCode);
	
	List<Cart> findByUserUserCode(Long userCode); // findByUserUserCode 메서드 추가
}