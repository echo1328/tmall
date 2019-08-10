package com.tmall.controller;

import com.tmall.domain.PageResult;
import com.tmall.domain.Result;
import com.tmall.domain.Seller;
import com.tmall.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther wenlongzhou
 * @date 2019/6/13 19:59
 */

@CrossOrigin
@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @CrossOrigin
    @GetMapping
    public List<Seller> findAll() {
        return sellerService.findAll();
    }

    @CrossOrigin
    @GetMapping("/{page}/{size}")
    public PageResult findPage(@PathVariable int page, @PathVariable int size) {
        return sellerService.findPage(page,size);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Seller findById(@PathVariable int id) {
        return sellerService.findById(id);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable int id) {
        try {
            sellerService.deleteById(id);
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
            sellerService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @CrossOrigin
    @PutMapping
    public Result update(@RequestBody Seller seller) {
        try {
            sellerService.update(seller);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

}
