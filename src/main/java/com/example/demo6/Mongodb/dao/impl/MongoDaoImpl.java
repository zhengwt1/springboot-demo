package com.example.demo6.Mongodb.dao.impl;

import com.example.demo6.Mongodb.po.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
* @Description:    dao实现类
* @Author:         ZWT
* @CreateDate:     2019/1/5 0005 下午 4:38
* @UpdateDate:     2019/1/5 0005 下午 4:38
 * Spring 给予了我们新的约定，在 Spring中只要定义一个 “接口名称+Impl” 的类并且提供与接口定义相同的 方法，
 *  Spring就会自动找到这个类对应的方法作为JPA接口定义的实现。
*/
@Repository
public class MongoDaoImpl {
    @Autowired
    public MongoTemplate mongoTemplate;

    /**
     * 查找一个person
     * @param name
     * @return
     */
    public Person findPerson(String name){
        Person person=mongoTemplate.findOne(Query.query(Criteria.where("name").is(name)),Person.class);
        return person;
    }

    /**
     * 插入数据
     * @param person
     * @return
     */
    public Person insertPerson(Person person){
        return  mongoTemplate.insert(person);
    }

    public void updatePerson(Person person){
        Update update=new Update();
        update.set("age",person.getAge());
        mongoTemplate.updateFirst(Query.query(Criteria.where("name").is(person.getName())),update,Person.class);
    }

    public void deletePerson(String name){
        mongoTemplate.remove(Query.query(Criteria.where("name").is(name)),Person.class);
    }
}
