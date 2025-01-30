package com.mftplus.spring02twopractice.model.service.impl;

import com.mftplus.spring02twopractice.model.entity.Employees;
import com.mftplus.spring02twopractice.model.entity.Person;
import com.mftplus.spring02twopractice.model.repository.EmployeesRepository;
import com.mftplus.spring02twopractice.model.repository.PersonRepository;
import com.mftplus.spring02twopractice.model.service.EmployeesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    private final EmployeesRepository employeesRepository;
    private final PersonRepository personRepository;

    public EmployeesServiceImpl(EmployeesRepository employeesRepository, PersonRepository personRepository) {
        this.employeesRepository = employeesRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void save(Employees employees) {
        employeesRepository.save(employees);
    }

    @Override
    public void update(Employees employees) {
        employeesRepository.save(employees);

    }

    @Override
    public void delete(Employees employees) {
        employeesRepository.delete(employees);

    }

    @Override
    public void deleteById(Long id) {
        employeesRepository.deleteById(id);

    }

    @Override
    public Employees findById(Long id) {
        return employeesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employees> findAll() {
        return employeesRepository.findAll();
    }

    @Override
    public Employees findByPerson(Person person) {
        Person person1 = personRepository.findPersonByUserList(person.getUserList().get(0));
        if (!person1.getUserList().isEmpty()) {
            return employeesRepository.findByPerson(person);
        } else {
            return null;
        }
    }
}
