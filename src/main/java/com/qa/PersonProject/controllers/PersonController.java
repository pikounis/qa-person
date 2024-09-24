package com.qa.PersonProject.controllers;

import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.service.PersonService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service) {
        super();
        this.service = service;
    }

    @GetMapping("/person/health")
    public String Health() {
        return "Person Controller is healthy.";
    }

    @GetMapping("/person/getAll")
    public List<Person> getAll() {
        return this.service.getAll();
    }

    @PostMapping("/person/create")
    public Person addPerson(@RequestBody @Valid Person person) {
        return this.service.addPerson(person);
    }

    @PutMapping("/person/update")
    public Person updatePerson(@PathParam("id") int id, @RequestBody @Valid Person person) {
        return this.service.updatePerson(id, person);
    }

    @DeleteMapping("/person/delete")
    public boolean deletePerson(@PathParam("id") int id, @RequestBody @Valid Person person) {
        return this.service.deletePerson(id);
    }
}
