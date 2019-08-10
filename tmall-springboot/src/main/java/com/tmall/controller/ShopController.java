package com.tmall.controller;

import com.tmall.domain.PageResult;
import com.tmall.domain.Result;
import com.tmall.domain.Shop;
import com.tmall.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther wenlongzhou
 * @date 2019/6/13 15:12
 */

@CrossOrigin
@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @CrossOrigin
    @GetMapping
    public List<Shop> findAll() {
        return shopService.findAll();
    }

    @CrossOrigin
    @GetMapping("/{page}/{size}")
    public PageResult findPage(@PathVariable int page, @PathVariable int size) {
        return shopService.findPage(page, size);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Shop findOne(@PathVariable int id) {
        return shopService.findById(id);
    }

    @CrossOrigin
    @PostMapping
    public Result add(@RequestBody Shop shop) {
        try {
            shopService.add(shop);
            return new Result(true,"增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"增加失败");
        }
    }

    @CrossOrigin
    @PutMapping
    public Result update(@RequestBody Shop shop) {
        try {
            shopService.update(shop);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable int id) {
        try {
            shopService.deleteById(id);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @CrossOrigin
    @DeleteMapping
    public Result delete(int[] ids) {
        try {
            shopService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

}
