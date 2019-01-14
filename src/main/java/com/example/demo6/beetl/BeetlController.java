package com.example.demo6.beetl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
/**
* @Description:    java类作用描述
* @Author:         ZWT
* @CreateDate:     2019/1/7 0007 下午 1:36
* @UpdateDate:     2019/1/7 0007 下午 1:36
*/
@Controller
public class BeetlController {

    @RequestMapping("testBeetl")
    public ModelAndView testBeetl(){
        ModelAndView modelAndView =new ModelAndView();
        User user=new User();
        user.setName("张三");
        user.setAge("20");
        user.setPassword("123456");
        List<String> stringList=new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        modelAndView.addObject("stringList",stringList);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("/beetl.html");
        return modelAndView;
    }
}
