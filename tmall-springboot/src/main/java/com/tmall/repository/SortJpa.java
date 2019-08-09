package com.tmall.repository;

import com.tmall.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SortJpa extends JpaRepository<Sort, Integer> {
}
