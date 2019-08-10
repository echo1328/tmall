package com.tmall.service;

import com.tmall.domain.PageResult;
import com.tmall.domain.Shop;

import java.util.List;

public interface ShopService {

    public List<Shop> findAll();

    public PageResult findPage(int pageNum, int pageSize);

    public Shop findById(int id);

    public void add(Shop shop);

    public void update(Shop shop);

    public void deleteById(int id);

    public void delete(int[] ids);

}
