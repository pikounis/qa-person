package com.qa.PersonProject.controllers;

import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.entities.PersonDTO;
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
    public List<PersonDTO> getAll() {
        return this.service.getAll();
    }

    @PostMapping("/person/create")
    public PersonDTO addPerson(@RequestBody @Valid Person person) {
        return this.service.addPerson(person);
    }

    @PutMapping("/person/update")
    public PersonDTO updatePerson(@PathParam("id") int id, @RequestBody @Valid Person person) {
        return this.service.updatePerson(id, person);
    }

    @DeleteMapping("/person/delete")
    public boolean deletePerson(@PathParam("id") int id, @RequestBody @Valid Person person) {
        return this.service.deletePerson(id);
    }

    @GetMapping("/person/getAllPeopleAge")
    public List<Person> getAllPeopleAge(@PathParam("age") int age) {
        return this.service.getAllPeopleWithAge(age);
    }

    @GetMapping("/person/getByAgeAndName")
    public List<Person> getAllPeopleWithAgeAndName(@PathParam("age") int age, @PathParam("name") String name) {
        return this.service.getAllPeopleWithAgeAndName(name, age);
    }

    @GetMapping("/person/getById")
    public PersonDTO getById(@PathParam("id") int id) {
        return this.service.getById(id);
    }

}
