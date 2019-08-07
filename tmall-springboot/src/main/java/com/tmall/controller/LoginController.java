package com.tmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: tmall-parent
 * @description: LoginController
 * @author: wenlongzhou
 * @create: 2019-08-07 11:05
 **/

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
