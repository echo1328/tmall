package com.tmall.repository;

import com.tmall.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopJpa extends JpaRepository<Shop, Integer> {
}
