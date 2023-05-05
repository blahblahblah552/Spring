package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person Person) {
        DB.add(new Person(id,Person.getName()));
      
        return 1;
    }

    @Override
    public List<Person> selectAllpeople() {
        return DB;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPeronById(id);
        if (personMaybe.isEmpty()) {
            return 0;
        } else {
            DB.remove(personMaybe.get());
            return 1;
        }
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
      return selectPeronById(id)
      .map(person -> {
        int indexOfPerson = DB.indexOf(person);
        if (indexOfPerson >= 0) {
            DB.set(indexOfPerson, new Person(id, update.getName()));
            return 1;
        }
        return 0;
      })
      .orElse(0);
     }

    @Override
    public Optional<Person> selectPeronById(UUID id) {
        return DB.stream()
        .filter(Person -> Person.getId().equals(id))
        .findFirst();
    }
}
