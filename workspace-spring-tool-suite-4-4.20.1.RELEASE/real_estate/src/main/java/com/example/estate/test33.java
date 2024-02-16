package com.example.estate;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class test33 {

	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<String> hello() {
        return Arrays.asList("서버 포트는 8080", "리액트 포트는 3000");
    }
}