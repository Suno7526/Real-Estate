package com.example.estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.estate.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{


}
