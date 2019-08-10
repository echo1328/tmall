package com.tmall.controller;

import com.tmall.domain.Result;
import com.tmall.domain.Sort;
import com.tmall.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/sorts")
public class SortController {

    @Autowired
    private SortService sortService;

    @CrossOrigin
    @GetMapping("/find/{parent_id}")
    public List<Sort> findByParentId(@PathVariable int parent_id) {
        return sortService.findByParentId(parent_id);
    }

    @CrossOrigin
    @GetMapping
    public List<Sort> findAll() {
        return sortService.findAll();
    }

    @CrossOrigin
    @PostMapping
    public Result add(@RequestBody Sort sort) {
        System.out.println("sort:"+sort.getParent_id()+"-"+sort.getName());
        try {
            sortService.add(sort);
            return new Result(true,"增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"增加失败");
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Sort findById(@PathVariable int id) {
        return sortService.findById(id);
    }

    @CrossOrigin
    @PutMapping
    public Result update(@RequestBody Sort sort) {
        System.out.println("sort:"+sort.getParent_id()+"-"+sort.getName());
        try {
            sortService.update(sort);
            return new Result(true,"更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"更新失败");
        }
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public Result update(@PathVariable int id) {
        try {
            sortService.deleteById(id);
            System.out.println("删除了分类id："+id);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

}
