package com.tmall.repository;

import com.tmall.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<User, Integer> {
}
