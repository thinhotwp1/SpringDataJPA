package com.example.springjpa.controller;

import com.example.springjpa.model.Person;
import com.example.springjpa.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    WebService webService;

    @GetMapping("/")
    public String getString(){
        return "hello";
    }

    @PostMapping("/add")
    public String addPerSon(@RequestBody Person person){
        if(webService.savePerson(person)){
            return person.toString();
        }else{
            return "Lỗi khi add person";
        }
    }

}
