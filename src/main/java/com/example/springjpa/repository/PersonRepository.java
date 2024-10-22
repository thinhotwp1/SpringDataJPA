package com.example.springjpa.repository;

import com.example.springjpa.model.User;
import org.hibernate.annotations.NotFound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<User,Long> {
    @Override
    Optional<User> findById(Long id);
}
