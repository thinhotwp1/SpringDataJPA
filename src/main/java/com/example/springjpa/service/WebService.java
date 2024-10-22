package com.example.springjpa.service;

import com.example.springjpa.model.User;
import com.example.springjpa.repository.PersonRepository;
import com.example.springjpa.rest.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebService {
    @Autowired
    PersonRepository repository;

    public boolean savePerson(User user) {
        try {
            repository.saveAndFlush(user);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public String generateStatistics() {
        User user = new User();
        user.setUserName("THINHLD");
        user.setPassword("123456");
        repository.save(user);
        for (int i = 0; i < 5; i++) {
            repository.getReferenceById(1L);
        }
        return "generateStatistics";
    }

    public ResponseData<User> findUser(Long id) {
        Optional<User> user = repository.findById(id);
        return user.map(ResponseData::new).orElseGet(() -> new ResponseData<>("User not found"));
    }
}
