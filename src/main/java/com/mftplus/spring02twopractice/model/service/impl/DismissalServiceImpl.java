package com.mftplus.spring02twopractice.model.service.impl;

import com.mftplus.spring02twopractice.model.entity.Dismissal;
import com.mftplus.spring02twopractice.model.entity.Employees;
import com.mftplus.spring02twopractice.model.entity.Person;
import com.mftplus.spring02twopractice.model.repository.DismissalRepository;
import com.mftplus.spring02twopractice.model.repository.EmployeesRepository;
import com.mftplus.spring02twopractice.model.repository.PersonRepository;
import com.mftplus.spring02twopractice.model.service.DismissalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DismissalServiceImpl implements DismissalService {
    private final DismissalRepository dismissalRepository;
    private final EmployeesRepository employeesRepository;
    private final PersonRepository personRepository;

    public DismissalServiceImpl(DismissalRepository dismissalRepository, EmployeesRepository employeesRepository, PersonRepository personRepository) {
        this.dismissalRepository = dismissalRepository;
        this.employeesRepository = employeesRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void save(Dismissal dismissal) {
        dismissalRepository.save(dismissal);
    }

    @Override
    public void update(Dismissal dismissal) {
        dismissalRepository.save(dismissal);
    }

    @Override
    public void delete(Dismissal dismissal) {
        dismissalRepository.delete(dismissal);
    }

    @Override
    public void deleteById(Long id) {
        dismissalRepository.deleteById(id);
    }

    @Override
    public Dismissal findById(Long id) {
        return dismissalRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dismissal> findAll() {
        return dismissalRepository.findAll();
    }

    @Override
    public Dismissal findByEmployees(Employees employees) {
        Employees employees1 = employeesRepository.findByPerson(employees.getPerson());
        if (!employees1.getPerson().getUserList().isEmpty()) {
            return dismissalRepository.findByEmployees(employees);
        } else {
            return null;
        }
    }

    @Override
    public Dismissal addEmployeesToDismissal(Employees employees) {
        Person person = personRepository.findPersonByUserList(employees.getPerson().getUserList().get(0));
        Employees employees1 = employeesRepository.findByPerson(employees.getPerson());
        List<Person> dismissalList = new ArrayList<>();
        if (!employees1.getPerson().getUserList().isEmpty() && (!employees1.getId().equals(person.getId()))) {
            dismissalList.add(person);
            return dismissalRepository.findById(person.getId()).get();
//            return dismissalRepository.addEmployeesToDismissal(employees);
        } else {
            return null;
        }
    }
}
