package com.tmall.service.impl;

import com.tmall.domain.Brand;
import com.tmall.domain.PageResult;
import com.tmall.repository.BrandJpa;
import com.tmall.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tmall-springboot
 * @description: BrandServiceImpl
 * @author: wenlongzhou
 * @create: 2019-08-07 10:35
 **/

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandJpa brandJpa;

    @Override
    public List<Brand> findAll() {
        return brandJpa.findAll();
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {

        return null;
    }
}
