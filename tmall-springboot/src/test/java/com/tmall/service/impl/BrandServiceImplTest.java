package com.tmall.service.impl;

import com.tmall.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandServiceImplTest {

    @Autowired
    private BrandService brandService;

    @Test
    public void hello() {
        System.out.println("Hello World!!!");
    }

    @Test
    public void findAll() {
        System.out.println(brandService.findAll());
    }
}