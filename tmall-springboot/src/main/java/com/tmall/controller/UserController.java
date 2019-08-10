package com.tmall.controller;

import com.tmall.domain.PageResult;
import com.tmall.domain.Result;
import com.tmall.domain.User;
import com.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @CrossOrigin
    @GetMapping("/{page}/{size}")
    public PageResult findPage(@PathVariable int page, @PathVariable int size) {
        System.out.println("user: page="+page+",size="+size);
        return userService.findPage(page,size);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @CrossOrigin
    @PutMapping
    public Result update(@RequestBody User user) {
        try {
            userService.update(user);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        try {
            userService.deleteById(id);
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
            userService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @CrossOrigin
    @PostMapping
    public Result add(@RequestBody User user) {
        try {
            userService.add(user);
            System.out.println(user);
            return new Result(true,"增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"增加失败");
        }
    }

    @CrossOrigin
    @PostMapping("/login")
    public Result login(String user_name, String user_pass) {
        System.out.println("用户名：" + user_name + "，密码：" + user_pass);
        boolean is = userService.login(user_name, user_pass);
        if (is) {
            return new Result(true,user_name);
        } else {
            return new Result(false,"登录失败");
        }
    }

}
