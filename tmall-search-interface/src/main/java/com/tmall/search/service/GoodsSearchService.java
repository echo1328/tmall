package com.tmall.search.service;

import com.tmall.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsSearchService {

    public Map search(Map searchMap);

    public List<Goods> searchByName(String name);

    public List<Goods> findAll();

    public List<Goods> search2(String key);

}
