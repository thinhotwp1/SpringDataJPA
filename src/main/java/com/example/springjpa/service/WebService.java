package com.example.springjpa.service;

import com.example.springjpa.model.Person;
import com.example.springjpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebService {
    @Autowired
    PersonRepository repository;

    public boolean savePerson(Person person) {
        try {
            repository.save(person);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
