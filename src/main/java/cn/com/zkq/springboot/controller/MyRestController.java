package cn.com.zkq.springboot.controller;

import cn.com.zkq.springboot.entity.User;
import cn.com.zkq.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  控制器
 */
@RestController
public class MyRestController {

    @Autowired
    private UserService userService;
    //测试访问方法
    @RequestMapping("/test")
    public @ResponseBody void test(){
        System.out.println("测试一");
    }

    //测试访问方法
    @RequestMapping("/loadAllUser")
    public @ResponseBody List<User> loadAllUser(){
        try {
            return userService.findAllUser();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
