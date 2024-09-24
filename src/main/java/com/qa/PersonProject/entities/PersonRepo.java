package com.qa.PersonProject.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

    List<Person> findPersonByAge(int age);

    @Query(value = "SELECT * FROM Person WHERE `firstname` = ?1 AND `age` = ?2", nativeQuery = true)
    List<Person> findPersonByNameAndAgeSQL(String name, int age);
}
