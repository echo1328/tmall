package com.tmall.service;

import com.tmall.domain.Goods;
import com.tmall.domain.PageResult;

import java.util.List;

public interface GoodsService {

    public List<Goods> findAll();

    public PageResult findPage(int pageNum, int pageSize);

    public void add(Goods goods);

    public Goods findById(int id);

    public void update(Goods goods);

    public void deleteById(int id);

    public void delete(int[] ids);

}
