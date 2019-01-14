package com.example.demo6.Mongodb.service.impl;

import com.example.demo6.Mongodb.dao.MongoDao;
import com.example.demo6.Mongodb.po.Person;
import com.example.demo6.Mongodb.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoServiceImpl implements MongoService {

    @Autowired
    public MongoDao mongoDao;

    @Override
    public Person findPerson(String name){
        return mongoDao.findPerson(name);
    }

    @Override
    public Person insertPerson(Person person){
        return  mongoDao.insertPerson(person);
    }

    @Override
    public void updatePerson(Person person) {
        mongoDao.updatePerson(person);
    }

    @Override
    public void deletePerson(String name) {
        mongoDao.deletePerson(name);
    }
}
