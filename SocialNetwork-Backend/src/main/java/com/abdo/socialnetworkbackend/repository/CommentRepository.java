package com.abdo.socialnetworkbackend.repository;

import com.abdo.socialnetworkbackend.entities.Comment;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    
}