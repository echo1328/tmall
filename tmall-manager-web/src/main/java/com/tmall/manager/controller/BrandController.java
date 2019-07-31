package com.tmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tmall.pojo.Brand;
import com.tmall.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: tmall-parent
 * @description: BrandController
 * @author: wenlongzhou
 * @create: 2019-07-25 12:47
 **/

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<Brand> findAll() {
        return brandService.findAll();
    }

}
