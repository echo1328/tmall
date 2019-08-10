package com.tmall.repository;

import com.tmall.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerJpa extends JpaRepository<Seller, Integer> {
}
