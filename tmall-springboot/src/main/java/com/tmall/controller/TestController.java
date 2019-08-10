package com.tmall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tmall-parent
 * @description: TestController
 * @author: wenlongzhou
 * @create: 2019-08-09 19:11
 **/

@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 配置多个路径都可以访问
     */

    @RequestMapping(value = {"/aaa","/bbb"}, method = {RequestMethod.GET,RequestMethod.POST})
    public void test() {

    }

    /**
     * params 规定请求时要带有指定的参数名和参数值
     * 代表请求时，必须带有name参数，并且值也为admin
     */

    @RequestMapping(value = "/test2", params = "name=admin")
    public void test2() {
        System.out.println("test2方法");
    }

    /**
     * @RequestParam 注解 规定请求时必须带有指定的参数名，但是参数值不规定
     * @param username
     * @param password
     */

    @RequestMapping("/login")
    public void login(@RequestParam String username, @RequestParam String password) {
        System.out.println("login方法");
    }

    /**
     * headers 规定请求时必须带有指定的头信息
     */

    @RequestMapping(value = "/headers", headers = "content-type=text/html")
    public void headers() {
        System.out.println("headers方法...html");
    }

    @RequestMapping(value = "/headers", headers = "content-type=text/xml")
    public void headers2() {
        System.out.println("headers方法...xml");
    }

    /**
     * @RequestBody: 把请求体的所有内容都封装到指定的对象上
     */

}
