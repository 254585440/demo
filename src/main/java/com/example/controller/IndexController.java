package com.example.controller;

import com.example.entity.userInfo;
import com.example.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    private userService userS;

    @RequestMapping("/index")
    public String index(){
        log.info("进入首页");
        return "demo";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestParam("username") String username,@RequestParam("pwd") String pwd){
        userInfo user = new userInfo();
        user.setUsername(username);
        user.setPwd(pwd);
        int i = userS.adduser(user);
        System.out.println("1");
        return "demo";
    }

    @RequestMapping("/selectAll")
    public String selectAll(){
        ModelAndView mv = new ModelAndView();
        List<userInfo> userInfoList = userS.selectAll();
//        mv.addObject("userList",userInfoList);
//        mv.setViewName("userInfo");
        return "demo";
    }

    @RequestMapping("/selectById")
    public String selectById(@RequestParam("id") String id){
        userInfo user = userS.selectById(Integer.valueOf(id));
        return "demo";
    }
}
