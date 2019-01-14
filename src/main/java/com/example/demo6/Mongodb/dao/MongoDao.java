package com.example.demo6.Mongodb.dao;

import com.example.demo6.Mongodb.po.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
* @Description:    dao接口
* @Author:         ZWT
* @CreateDate:     2019/1/5 0005 下午 4:36
* @UpdateDate:     2019/1/5 0005 下午 4:36
*/
@Repository
public interface MongoDao extends MongoRepository<Person,String> {
    public Person findPerson(String name);
    public Person insertPerson(Person person);
    public void updatePerson(Person person);
    public void deletePerson(String name);
}
