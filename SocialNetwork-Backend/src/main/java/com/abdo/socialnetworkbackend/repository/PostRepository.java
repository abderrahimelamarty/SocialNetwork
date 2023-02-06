package com.abdo.socialnetworkbackend.repository;

import java.util.List;
import java.util.Optional;

import com.abdo.socialnetworkbackend.entities.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    Optional<List<Post>> findByUserId(String id);
    Optional<List<Post>> findByUserIdOrderByCreatedAtDesc(String id);
    
}
