package com.example.estate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.estate.entity.Product;
import com.example.estate.entity.ViewedProduct;
import com.example.estate.entity.User;
import com.example.estate.service.ProductService;
import com.example.estate.service.ViewedProductService;
import com.example.estate.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class viewedProductController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;
    
   
}
