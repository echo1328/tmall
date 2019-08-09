package com.tmall.service;

import com.tmall.domain.Brand;
import com.tmall.domain.PageResult;

import java.util.List;

public interface BrandService {

    public List<Brand> findAll();

    public PageResult findPage(int pageNum, int pageSize);

    public void add(Brand brand);

    public Brand findOne(int id);

    public void update(Brand brand);

    public void delete(int[] ids);

    public void delete(int id);

    public PageResult findPage(Brand brand, int pageNum, int pageSize);

}
