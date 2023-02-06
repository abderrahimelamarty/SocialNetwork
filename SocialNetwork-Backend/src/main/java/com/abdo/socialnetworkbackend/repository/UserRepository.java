package com.abdo.socialnetworkbackend.repository;

import java.util.Optional;

import com.abdo.socialnetworkbackend.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
