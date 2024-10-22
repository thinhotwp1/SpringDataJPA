package com.example.springjpa.controller;

import com.example.springjpa.model.User;
import com.example.springjpa.rest.ResponseData;
import com.example.springjpa.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

    @Autowired
    WebService webService;

    @GetMapping("/find")
    public ResponseData<User> getString(@RequestParam(name = "id") Long id){
        return webService.findUser(id);
    }

    @PostMapping("/add")
    public String addPerSon(@RequestBody User user){
        if(webService.savePerson(user)){
            return user.toString();
        }else{
            return "Lỗi khi add person";
        }
    }

    @GetMapping("/generate_statistics")
    public String generateStatistics(){
        return webService.generateStatistics();
    }

}
