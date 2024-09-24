package com.qa.PersonProject.service;

import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.entities.PersonDTO;
import com.qa.PersonProject.entities.PersonRepo;
import com.qa.PersonProject.exceptions.PersonNotFoundException;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepo repo;

    private ModelMapper mapper;

    public PersonService(PersonRepo repo, ModelMapper mapper) {
        super();
        this.repo = repo;
        this.mapper = mapper;
    }

//    private List<Person> people = new ArrayList<>();


    private PersonDTO mapToDTO(Person person) {
        return this.mapper.map(person, PersonDTO.class);
    }

    public String Health() {
        return "Person Controller is healthy.";
    }

    public List<PersonDTO> getAll() {
//        return this.people;
        return this.repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }


    public PersonDTO addPerson(Person person) {
//        this.people.add(person);
//        return this.people.get(this.people.size()-1);
//        LOGIC goes here
        Person saved = this.repo.save(person);
        return this.mapToDTO(saved);
    }

    public PersonDTO updatePerson(int id, Person person) {
//        this.people.remove(id);
//        this.people.add(id, person);
//        return this.people.get(id);
        Optional<Person> existingPerson = this.repo.findById(id);
        Person existing = existingPerson.get();
        existing.setAge(person.getAge());
        existing.setFirstname(person.getFirstname());
        existing.setLastname(person.getLastname());
        Person updated = this.repo.save(existing);
        return this.mapToDTO(updated);
    }

    public boolean deletePerson(int id) {
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;
    }

    public List<Person> getAllPeopleWithAge(int age) {
        return this.repo.findPersonByAge(age);
    }

    public List<Person> getAllPeopleWithAgeAndName(String name, int age) {
        return this.repo.findPersonByNameAndAgeSQL(name, age);
    }

    public PersonDTO getById(int id) {
        Person found = this.repo.findById(id).orElseThrow(PersonNotFoundException::new);
        return this.mapToDTO(found);
    }

}