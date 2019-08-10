package com.tmall.repository;

import com.tmall.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsJpa extends JpaRepository<Goods, Integer> {
}
