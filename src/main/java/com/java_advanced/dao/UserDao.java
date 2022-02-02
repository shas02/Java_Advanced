package com.java_advanced.dao;

import com.java_advanced.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDao extends JpaRepository<User, Integer> {


    UserDetails findByUsername(String username);
}
