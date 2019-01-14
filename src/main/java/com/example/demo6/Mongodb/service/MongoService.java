package com.example.demo6.Mongodb.service;

import com.example.demo6.Mongodb.po.Person;

public interface MongoService {
    public Person findPerson(String name);
    public Person insertPerson(Person person);
    public void updatePerson(Person person);
    public void deletePerson(String name);
}
