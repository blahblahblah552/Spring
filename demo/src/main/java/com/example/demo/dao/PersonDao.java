package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.UUID;


public interface PersonDao {
    
    int insertPerson(UUID id, Person Person);

    default int insertPerson(Person Person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, Person);
    }
}
