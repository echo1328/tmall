package com.tmall.controller;

import com.tmall.domain.Goods;
import com.tmall.domain.PageResult;
import com.tmall.domain.Result;
import com.tmall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @CrossOrigin
    @GetMapping
    public List<Goods> findAll() {
        return goodsService.findAll();
    }

    @CrossOrigin
    @GetMapping("/{page}/{size}")
    public PageResult findPage(@PathVariable int page, @PathVariable int size) {
        System.out.println("goods: page="+page+",size="+size);
        return goodsService.findPage(page,size);
    }

    @CrossOrigin
    @PostMapping
    public Result add(@RequestBody Goods goods) {
        try {
            System.out.print(goods.getName());
            goodsService.add(goods);
            return new Result(true,"增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"增加失败");
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Goods findById(@PathVariable int id) {
        return goodsService.findById(id);
    }

    @CrossOrigin
    @PutMapping
    public void update(@RequestBody Goods goods) {
        goodsService.update(goods);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        goodsService.deleteById(id);
    }

    @CrossOrigin
    @DeleteMapping
    public void delete(int[] ids) {
        goodsService.delete(ids);
    }

}
