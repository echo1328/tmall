package com.tmall.repository;

import com.tmall.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandJpa extends JpaRepository<Brand, Integer> {
}
