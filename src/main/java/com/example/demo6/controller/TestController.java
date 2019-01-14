package com.example.demo6.controller;

import com.example.demo6.po.Student;
import com.example.demo6.swagger.TestSwagger;
import com.example.demo6.swagger.service.ISwaggerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @Autowired
    Student student;

    @Autowired
    ISwaggerService swaggerService;
    @RequestMapping("test")
    @ResponseBody
    public Student  test(){
        return student;
    }

    @RequestMapping("selecetPage")
    public ModelAndView selecetPage(){
        Integer currentPage=1;
        Integer pageSize=3;
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("beetl.html");
        modelAndView.addObject("swaggerPage",swaggerService.selectPage(currentPage,pageSize));
        return modelAndView;
    }
}
