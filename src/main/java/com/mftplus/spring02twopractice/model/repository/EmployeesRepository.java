package com.mftplus.spring02twopractice.model.repository;

import com.mftplus.spring02twopractice.model.entity.Employees;
import com.mftplus.spring02twopractice.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    Employees findByPerson(Person person);
}
