package com.mftplus.spring02twopractice.model.service;

import com.mftplus.spring02twopractice.model.entity.Dismissal;
import com.mftplus.spring02twopractice.model.entity.Employees;

import java.util.List;

public interface DismissalService {
    void save(Dismissal dismissal);

    void update(Dismissal dismissal);

    void delete(Dismissal dismissal);

    void deleteById(Long id);

    Dismissal findById(Long id);

    List<Dismissal> findAll();

    Dismissal findByEmployees(Employees employees);

    Dismissal addEmployeesToDismissal(Employees employees);

}
