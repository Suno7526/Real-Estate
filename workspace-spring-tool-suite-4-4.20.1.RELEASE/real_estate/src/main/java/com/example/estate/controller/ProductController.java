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

    @PostMapping("/saveProduct")
    public ResponseEntity<String> saveProduct(@RequestParam("productImage") MultipartFile productImage,
                                              @RequestParam("productName") String productName,
                                              @RequestParam("information") String information,
                                              @RequestParam("productPrice") int productPrice,
                                              @RequestParam("companyName") String companyName,
                                              @RequestParam("productStuck") int productStuck,
                                              @RequestParam("productSize") String productSize) {
        try {
            byte[] imageBytes = productImage.getBytes();
            productService.saveProduct(imageBytes, productName, information, productPrice, companyName, productStuck, productSize);
            return new ResponseEntity<>("상품 등록 성공", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("상품 등록에 실패했습니다 다시 시도해주세요.", HttpStatus.INTERNAL_SERVER_ERROR);
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

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/getProduct/{productCode}") // 새로운 엔드포인트 추가
    public ResponseEntity<Product> getProduct(@PathVariable("productCode") Long productCode) {
        Product product = productService.findByProductCode(productCode);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
