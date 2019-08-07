package com.tmall.service;

import com.tmall.domain.Brand;
import com.tmall.domain.PageResult;

import java.util.List;

public interface BrandService {

    public List<Brand> findAll();

    public PageResult findPage(int pageNum, int pageSize);

}
