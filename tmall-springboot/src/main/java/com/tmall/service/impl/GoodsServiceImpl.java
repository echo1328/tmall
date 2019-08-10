package com.tmall.service.impl;

import com.tmall.domain.Goods;
import com.tmall.domain.PageResult;
import com.tmall.repository.GoodsJpa;
import com.tmall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsJpa goodsJpa;

    @Override
    public List<Goods> findAll() {
        return goodsJpa.findAll();
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Goods> page = goodsJpa.findAll(pageable);
        return new PageResult(page.getTotalElements(),page.getContent());
    }

    @Override
    public void add(Goods goods) {
        goods.setStatus(0);
        goodsJpa.saveAndFlush(goods);
    }

    @Override
    public Goods findById(int id) {
        return goodsJpa.findById(id).get();
    }

    @Override
    public void update(Goods goods) {
        goodsJpa.saveAndFlush(goods);
    }

    @Override
    public void deleteById(int id) {
        goodsJpa.deleteById(id);
    }

    @Override
    public void delete(int[] ids) {
        for (int i = 0; i < ids.length; i++) {
            goodsJpa.deleteById(i);
        }
    }

}
