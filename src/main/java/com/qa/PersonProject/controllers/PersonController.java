package com.qa.PersonProject.controllers;

import com.qa.PersonProject.entities.Person;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private List<Person> people = new ArrayList<>();

    @GetMapping("/person/health")
    public String Health() {
        return "Person Controller is healthy.";
    }

    @GetMapping("/person/getAll")
    public List<Person> getAll() {
        return this.people;
    }

    @PostMapping("/person/create")
    public boolean addPerson(@RequestBody @Valid Person person) {
        return this.people.add(person);
    }
}
