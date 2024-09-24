package com.qa.PersonProject.service;

import com.qa.PersonProject.entities.Person;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private List<Person> people = new ArrayList<>();

    public String Health() {
        return "Person Controller is healthy.";
    }

    public List<Person> getAll() {
        return this.people;
    }

    public Person addPerson(Person person) {
        this.people.add(person);
        return this.people.get(this.people.size()-1);
    }

    public Person updatePerson(int id, Person person) {
        this.people.remove(id);
        this.people.add(id, person);
        return this.people.get(id);
    }

    public Person deletePerson(int id) {
        return this.people.remove(id);
    }
}