package com.tmall.search.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tmall.pojo.Goods;
import com.tmall.search.repositories.GoodsRepository;
import com.tmall.search.service.GoodsSearchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: tmall-parent
 * @description: GoodsSearchServiceImpl
 * @author: wenlongzhou
 * @create: 2019-08-04 22:41
 **/

@Service
public class GoodsSearchServiceImpl implements GoodsSearchService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Map search(Map searchMap) {
        Map map = new HashMap();
        String word = (String) searchMap.get("key");
        List<Goods> list = goodsRepository.findByNameLikeOrCaptionLikeOrIntroductionLikeOrActivityLike(word,word,word,word);;
        map.put("rows",list);
        return map;
    }

    @Override
    public List<Goods> searchByName(String name) {
        List<Goods> list = goodsRepository.findByNameLike(name);
        return list;
    }

    @Override
    public List<Goods> findAll() {
        Iterable<Goods> iterable = goodsRepository.findAll();
        List<Goods> list = new ArrayList<>();
        for (Goods goods : iterable) {
            list.add(goods);
        }
        return list;
    }

    @Override
    public List<Goods> search2(String key) {
        return goodsRepository.findByNameLikeOrCaptionLikeOrIntroductionLikeOrActivityLike(key,key,key,key);
    }

}
