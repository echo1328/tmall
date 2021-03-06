package com.tmall.service;

import com.tmall.domain.Sort;

import java.util.List;

public interface SortService {

    public List<Sort> findByParentId(int parent_id);

    public List<Sort> findAll();

    public void add(Sort sort);

    public Sort findById(int id);

    public void update(Sort sort);

    public void deleteById(int id);

}
