package com.mftplus.spring02twopractice.controller;

import com.mftplus.spring02twopractice.model.entity.Person;
import com.mftplus.spring02twopractice.model.entity.User;
import com.mftplus.spring02twopractice.model.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
@Slf4j
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String getPersons(Model model) {
        model.addAttribute("person", new Person());
        log.info("saved person {}", personService.findAll());
        model.addAttribute("persons", personService.findAll());
        return "persons";
    }

    @GetMapping("/{id}")
    public String getPersonById(@PathVariable Long id, Model model) {
        log.info("found person with id {}", personService.findById(id));
        model.addAttribute("person", personService.findById(id));
        return "editPersons";

    }

    @GetMapping("/name/{name}")
    public String getPersonByName(@PathVariable String name, Model model) {
        log.info("found user with name {}", personService.findByName(name));
        model.addAttribute("person", personService.findByName(name));
        return "editPersons";

    }

    @GetMapping("/username/{username}")
    public String getPersonByUsername(@PathVariable String username, Model model,User user) {
        log.info("found person with username {}", personService.findPersonByUser(user));
        model.addAttribute("personUser", personService.findPersonByUser(user));
        return "redirect:/persons";

    }


    @PostMapping
    public String savePerson(Person person) {
        personService.save(person);
        log.info("saved person {}", person);
        return "redirect:/persons";

    }

    @PutMapping
    public String updatePerson(Person person) {
        personService.update(person);
        log.info("updated person {}", person);
        return "redirect:/persons";

    }

    @DeleteMapping("/{id}")
    public String deletePersonById(@PathVariable Long id) {
        personService.deleteById(id);
        return "redirect:/persons";
    }

    @DeleteMapping("/name/{name}")
    public String deletePersonByName(@PathVariable String name) {
        personService.delete(personService.findByName(name).get(0));
        return "redirect:/persons";
    }


}
