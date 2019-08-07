package com.tmall.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tmall-parent
 * @description: HelloWorldController
 * @author: wenlongzhou
 * @create: 2019-08-07 08:59
 **/

@RestController
public class HelloWorldController {

    @Autowired
    private Environment env;

    @RequestMapping("/info")
    public String info() {
        return "Hello World!" + env.getProperty("url");
    }

}
