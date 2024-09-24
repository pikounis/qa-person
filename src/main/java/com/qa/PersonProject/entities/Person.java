package com.qa.PersonProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Entity
public class Person {
    @Size(min = 2, max = 30)
    @NotNull
    String firstname;

    @Min(18)
    @Max(75)
    public int getAge() {
        return age;
    }

    public void setAge(@Min(18) @Max(75) int age) {
        this.age = age;
    }

    public @Size(min = 2, max = 30) @NotNull String getLastname() {
        return lastname;
    }

    public void setLastname(@Size(min = 2, max = 30) @NotNull String lastname) {
        this.lastname = lastname;
    }

    public @Size(min = 2, max = 30) @NotNull String getFirstname() {
        return firstname;
    }

    public void setFirstname(@Size(min = 2, max = 30) @NotNull String firstname) {
        this.firstname = firstname;
    }

    @Size(min = 2, max = 30)
    @NotNull
    String lastname;

    public Person() {

    }

    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    @Min(18)
    @Max(75)
    int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <-- AUTO INCREMENT
    private int id;
}
