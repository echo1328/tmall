package com.tmall.controller;

import com.tmall.domain.Brand;
import com.tmall.domain.PageResult;
import com.tmall.domain.Result;
import com.tmall.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: tmall-springboot
 * @description: BrandController
 * @author: wenlongzhou
 * @create: 2019-08-07 10:43
 **/

@CrossOrigin
@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @CrossOrigin
    @GetMapping
    public List<Brand> findAll() {
        return brandService.findAll();
    }

    @CrossOrigin
    @GetMapping("/{page}/{size}")
    public PageResult findPage(@PathVariable int page, @PathVariable int size) {
        return brandService.findPage(page, size);
    }

    @CrossOrigin
    @PostMapping
    public Result add(@RequestBody Brand brand) {
        try {
            brandService.add(brand);
            System.out.println(brand.getName()+"-"+brand.getFirst_char());
            return new Result(true,"增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"增加失败");
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Brand findById(@PathVariable int id) {
        return brandService.findById(id);
    }

    @CrossOrigin
    @PutMapping
    public Result update(@RequestBody Brand brand) {
        try {
            brandService.update(brand);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

    @CrossOrigin
    @DeleteMapping
    public Result delete(int[] ids) {
        System.out.println("ids:" + ids);
        try {
            brandService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable int id) {
        try {
            brandService.deleteById(id);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

}
