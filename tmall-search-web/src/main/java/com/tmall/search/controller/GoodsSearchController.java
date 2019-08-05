package com.tmall.search.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tmall.pojo.Goods;
import com.tmall.search.service.GoodsSearchService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: tmall-parent
 * @description: GoodsSearchController
 * @author: wenlongzhou
 * @create: 2019-08-04 22:54
 **/

@RestController
@RequestMapping("/goodssearch")
public class GoodsSearchController {

    @Reference
    private GoodsSearchService goodsSearchService;

    @RequestMapping("/search")
    public Map search(@RequestBody Map searchMap) {
        return goodsSearchService.search(searchMap);
    }

    @RequestMapping("/searchByName")
    public List<Goods> searchByName(String name) {
        System.out.println("name=" + name);
        List<Goods> list = goodsSearchService.searchByName(name);
        System.out.println("list=" + list);
        return list;
    }

    @RequestMapping("/findAll")
    public List<Goods> findAll() {
        return goodsSearchService.findAll();
    }

    @RequestMapping("/search2")
    public List<Goods> search2(String key) {
        return goodsSearchService.search2(key);
    }

}
