package com.tmall.controller;

import com.tmall.domain.Result;
import com.tmall.domain.Sort;
import com.tmall.service.SortServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: tmall-springboot
 * @description: SortController
 * @author: wenlongzhou
 * @create: 2019-08-09 15:59
 **/

/**
 * 品牌资源控制器
 */

@RestController
@RequestMapping("/sortstest")
public class SortControllerTest {

    @Autowired
    private SortServiceTest sortServiceTest;

    //@RequestMapping(value = "/sorts", method = RequestMethod.GET)
    @GetMapping
    public List<Sort> findAll() {
        return sortServiceTest.findAll();
    }

    //使用路径占位符(路径传参)
    @GetMapping("/{id}")
    public Sort findById(@PathVariable("id") int id) {
        return sortServiceTest.findById(id);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") int id, HttpServletResponse response) {
        try {
            sortServiceTest.deleteById(id);
            //response.setStatus(204);
            //response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @PostMapping
    public Sort add(@RequestBody Sort sort) {
        return sortServiceTest.add(sort);
    }

}
