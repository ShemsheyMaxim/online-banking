package com.springboot.onlinebanking.repository;

import com.springboot.onlinebanking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
