package com.mftplus.spring02twopractice.model.repository;

import com.mftplus.spring02twopractice.model.entity.Dismissal;
import com.mftplus.spring02twopractice.model.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DismissalRepository extends JpaRepository<Dismissal, Long> {
    Dismissal findByEmployees(Employees employees);
}
