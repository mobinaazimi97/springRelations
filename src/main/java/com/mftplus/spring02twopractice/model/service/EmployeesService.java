package com.mftplus.spring02twopractice.model.service;

import com.mftplus.spring02twopractice.model.entity.Employees;
import com.mftplus.spring02twopractice.model.entity.Person;
import com.mftplus.spring02twopractice.model.entity.User;

import java.util.List;

public interface EmployeesService {
    void save(Employees employees);
    void update(Employees employees);
    void delete(Employees employees);
    void deleteById(Long id);
    Employees findById(Long id);
    List<Employees> findAll();
    Employees findByPerson(Person person);
}
