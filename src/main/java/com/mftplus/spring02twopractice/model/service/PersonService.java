package com.mftplus.spring02twopractice.model.service;


import com.mftplus.spring02twopractice.model.entity.Person;
import com.mftplus.spring02twopractice.model.entity.User;

import java.util.List;

public interface PersonService {
    void save(Person person);
    void update(Person person);
    void delete(Person person);
    void deleteById(Long id);
    Person findById(Long id);
    List<Person> findAll();
    List<Person>findByName(String name);
   Person findPersonByUser(User user);
}
