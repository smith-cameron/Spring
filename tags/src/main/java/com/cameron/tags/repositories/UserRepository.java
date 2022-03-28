package com.cameron.tags.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cameron.tags.models.User;


public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    

}
