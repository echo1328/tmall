package com.tmall.service;

import com.tmall.domain.Sort;

import java.util.List;

public interface SortService {

    public List<Sort> findAll();

    public Sort findById(int id);

    public void deleteById(int id);

    public Sort add(Sort sort);

}
