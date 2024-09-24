package com.qa.PersonProject.service;

import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.entities.PersonRepo;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepo repo;

    public PersonService(PersonRepo repo) {
        super();
        this.repo = repo;
    }

//    private List<Person> people = new ArrayList<>();

    public String Health() {
        return "Person Controller is healthy.";
    }

    public List<Person> getAll() {
//        return this.people;
        return this.repo.findAll();
    }

    public Person addPerson(Person person) {
//        this.people.add(person);
//        return this.people.get(this.people.size()-1);
//        LOGIC goes here
        return this.repo.save(person);
    }

    public Person updatePerson(int id, Person person) {
//        this.people.remove(id);
//        this.people.add(id, person);
//        return this.people.get(id);
        Optional<Person> existingPerson = this.repo.findById(id);
        Person existing = existingPerson.get();
        existing.setAge(person.getAge());
        existing.setFirstname(person.getFirstname());
        existing.setLastname(person.getLastname());
        return this.repo.save(existing);
    }

    public boolean deletePerson(int id) {
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;
    }

    public List<Person> getAllPeopleWithAge(int age) {
        return this.repo.findPersonByAge(age);
    }

}