package com.example.estate.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.estate.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findByProductCode(Long productCode);
	
//	@Query("SELECT p FROM Product p JOIN FETCH p.viewedByUsers vu WHERE vu.user.email = :userEmail ORDER BY vu.viewedAt DESC")
//    List<Product> findRecentlyViewedProducts(@Param("userEmail") String userEmail, Pageable pageable);
//	
}
