package com.example.demo6.Mongodb.controller;

import com.example.demo6.Mongodb.po.Person;
import com.example.demo6.Mongodb.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
* @Description:    controller层
* @Author:         ZWT
* @CreateDate:     2019/1/5 0005 下午 5:55
* @UpdateDate:     2019/1/5 0005 下午 5:55
*/
@Controller
public class MongoController {
    @Autowired
    public MongoService mongoServic;

    /**
     * 、查找一个person对象
     * @param name
     * @return
     */
    @RequestMapping("findPerson")
    @ResponseBody
    public Person findPerson(@RequestParam("name") String name){
        name="道具卡3";
        Person person=mongoServic.findPerson(name);
        System.out.println("查询结果："+person.toString());
        return person;
    }

    /**
     * 插入
     * @param person
     * @return
     */
    @RequestMapping("insert")
    @ResponseBody
    public Person insert(Person person){
        person.setName("道具卡3");
        person.setAge(22);
        person.setSex("女");
        Person person1=mongoServic.insertPerson(person);
        return person1;
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("delete/{name}")
    @ResponseBody
    public String delete(@PathVariable String name){
        name="道具卡1";
        mongoServic.deletePerson(name);
        return "ok";
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public String update(){
        Person person=new Person();
        person.setName("道具卡0");
        person.setAge(28);
        mongoServic.updatePerson(person);
        return "ok";
    }
}
