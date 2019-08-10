package com.tmall.service.impl;

import com.tmall.domain.PageResult;
import com.tmall.domain.Shop;
import com.tmall.repository.ShopJpa;
import com.tmall.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther wenlongzhou
 * @date 2019/6/13 15:10
 */

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopJpa shopJpa;

    @Override
    public List<Shop> findAll() {
        return shopJpa.findAll();
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Shop> page = shopJpa.findAll(pageable);
        return new PageResult(page.getTotalElements(), page.getContent());
    }

    @Override
    public Shop findById(int id) {
        return shopJpa.findById(id).get();
    }

    @Override
    public void add(Shop shop) {
        shopJpa.saveAndFlush(shop);
    }

    @Override
    public void update(Shop shop) {
        shopJpa.saveAndFlush(shop);
    }

    @Override
    public void deleteById(int id) {
        shopJpa.deleteById(id);
    }

    @Override
    public void delete(int[] ids) {
        for (int id : ids) {
            shopJpa.deleteById(id);
        }
    }

}
