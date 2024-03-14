package com.example.estate.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.estate.entity.ViewedProduct;
import com.example.estate.entity.User;

public interface ViewedProductRepository extends JpaRepository<ViewedProduct, Long> {
	
}
