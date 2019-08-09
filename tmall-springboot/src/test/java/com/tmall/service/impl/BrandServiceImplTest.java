package com.tmall.service.impl;

import com.tmall.domain.Brand;
import com.tmall.repository.BrandJpa;
import com.tmall.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandServiceImplTest {

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandJpa brandJpa;

    @Test
    public void hello() {
        System.out.println("Hello World!!!");
    }

    @Test
    public void findAll() {
        System.out.println(brandService.findAll());
    }

    @Test
    public void findPage() {
        Pageable pageable = PageRequest.of(0,3);
        Page<Brand> page = brandJpa.findAll(pageable);
        System.out.println("总页数：" + page.getTotalPages());
    }

    @Test
    public void findWithExample() {
        Brand brand = new Brand();
        brand.setName("三星");
        Example<Brand> example = Example.of(brand);
        System.out.println(brandJpa.findAll(example));
    }
}