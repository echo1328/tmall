package com.tmall.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tmall.mapper.BrandMapper;
import com.tmall.pojo.Brand;
import com.tmall.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: tmall-parent
 * @description: BrandServiceImpl
 * @author: wenlongzhou
 * @create: 2019-07-25 12:39
 **/

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectByExample(null);
    }

}
