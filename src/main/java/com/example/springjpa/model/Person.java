package com.example.springjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "person")
public class Person {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int age;
}
