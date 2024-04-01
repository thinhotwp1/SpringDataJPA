package com.example.springjpa.service;

import com.example.springjpa.model.User;
import com.example.springjpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebService {
    @Autowired
    PersonRepository repository;

    public boolean savePerson(User user) {
        try {
            repository.save(user);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
