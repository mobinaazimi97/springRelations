package com.mftplus.spring02twopractice.model.service.impl;

import com.mftplus.spring02twopractice.model.entity.Person;
import com.mftplus.spring02twopractice.model.entity.User;
import com.mftplus.spring02twopractice.model.repository.PersonRepository;
import com.mftplus.spring02twopractice.model.repository.UserRepository;
import com.mftplus.spring02twopractice.model.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final UserRepository userRepository;

    public PersonServiceImpl(PersonRepository personRepository, UserRepository userRepository) {
        this.personRepository = personRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);

    }

    @Override
    public void update(Person person) {
        personRepository.save(person);

    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);

    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);

    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }

    @Override
    public Person findPersonByUser(User user) {
        User user1=userRepository.findByUsername(user.getUsername());
        if (user1.getUsername()!=null) {
            return personRepository.findPersonByUserList(user);
        }else {
            return null;
        }

    }

//    @Override
//    public Person findPersonByUserList(String username) {
//        //TODO :
//Person person=new Person();
////        if(!person.getUserList().isEmpty())
//        // if (userRepository.findByUsername(username)!=null)
//        if (person.getUserList().get(0).getUsername().equals(username)) {
//            return personRepository.findPersonByUserList(username);
//        }else {
//            return null;
//        }
////        return personRepository.findPersonByUsername(username);
//    }
}
