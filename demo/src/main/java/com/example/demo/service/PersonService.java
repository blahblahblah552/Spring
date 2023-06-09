package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

@Service
public class PersonService {
    
    private final PersonDao PersonDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao")PersonDao personDao) {
        this.PersonDao = personDao;
    }

    public int addPerson(Person person){
        return PersonDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return PersonDao.selectAllpeople();
    }

    public Optional<Person> selectPeronById(UUID id){
        return PersonDao.selectPeronById(id);
    }

    public int deletePersonById(UUID id){
        return PersonDao.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person person){
        return PersonDao.updatePersonById(id, person);
    }
}
