package com.chenzj36.controller;

import com.chenzj36.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/2/8 10:55
 * @Description
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    @ApiOperation("测试controller")
    public String hello(){
        return "hello";
    }

    @ApiOperation("只要返回值中有pojo，该实体类就会被swagger扫描到")
    @GetMapping("/helloUser")
    @ResponseBody
    public User helloUser(){
        return new User();
    }

    @ApiOperation("测试500以及post")
    @PostMapping("/pott")
    public String postt(@ApiParam("com.chenzj36.pojo下的User对象") User user){
        int i = 3/0;
        return "no return";
    }

}
