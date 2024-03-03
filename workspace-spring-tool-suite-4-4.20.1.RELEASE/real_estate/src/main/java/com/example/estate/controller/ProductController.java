package com.example.estate.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.estate.entity.Product;
import com.example.estate.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

	@Autowired
	private ProductService productService;

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/saveProduct")
	public ResponseEntity<String> saveProduct(@RequestParam("productImage") MultipartFile productImage,
			@RequestParam("productName") String productName, @RequestParam("infomation") String infomation,
			@RequestParam("productPrice") int productPrice) {
		try {
			byte[] imageBytes = productImage.getBytes();
			productService.saveProduct(imageBytes, productName, infomation, productPrice);
			return new ResponseEntity<>("Product saved successfully", HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to save product. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getProductImage/{productCode}")
	public ResponseEntity<byte[]> getProductImage(@PathVariable("productCode") Long productCode) {
		try {
			byte[] imageBytes = productService.getProductImage(productCode);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG); // 이미지 타입에 따라 변경
			return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getProducts")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> productList = productService.getAllProducts();
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}
}
