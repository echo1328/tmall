package com.tmall.service.impl;

import com.tmall.domain.Brand;
import com.tmall.domain.PageResult;
import com.tmall.repository.BrandJpa;
import com.tmall.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Brand> page = brandJpa.findAll(pageable);
        return new PageResult(page.getTotalElements(), page.getContent());
    }

    @Override
    public void add(Brand brand) {
        brandJpa.saveAndFlush(brand);
    }

    @Override
    public Brand findOne(int id) {
        Optional<Brand> optional = brandJpa.findById(id);
        Brand brand = optional.get();
        return brand;
    }

    @Override
    public void update(Brand brand) {
        brandJpa.saveAndFlush(brand);
    }

    @Override
    public void delete(int[] ids) {
        for(int id : ids) {
            brandJpa.deleteById(id);
        }
    }

    @Override
    public void delete(int id) {
        brandJpa.deleteById(id);
    }

    @Override
    public PageResult findPage(Brand brand, int pageNum, int pageSize) {
        Example<Brand> example = Example.of(brand);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Brand> page = brandJpa.findAll(example, pageable);
        return new PageResult(page.getTotalElements(),page.getContent());
    }

}
