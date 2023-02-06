package com.abdo.socialnetworkbackend.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.abdo.socialnetworkbackend.entities.Comment;
import com.abdo.socialnetworkbackend.entities.Post;
import com.abdo.socialnetworkbackend.repository.CommentRepository;
import com.abdo.socialnetworkbackend.repository.PostRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private PostService postService;

    public Post insertComment(Comment inputComment, String inputPostId) {

        Optional<Post> optPost = postRepo.findById(inputPostId);
        if (optPost.isEmpty()) {
            return null;
        } else {
            inputComment.setCreatedAt(Instant.now());
            commentRepo.save(inputComment);
            Post targetPost = optPost.get();
            List<Comment> commentList = targetPost.getComment();
            if (commentList == null) {
                commentList = new ArrayList<>();
            }
            commentList.add(inputComment);
            targetPost.setComment(commentList);
           Post post= postService.updatePostByComment(targetPost);
            return post;

        }
    }

    public List<Comment> getComments(String inputPostId) {

        Optional<Post> optTargetPost = postRepo.findById(inputPostId);
        if (optTargetPost.isEmpty()) {
           return null;
        } else {
            Post targetPost = optTargetPost.get();
            List<Comment> commentList = targetPost.getComment();
            if (commentList.size() > 0) {
               return commentList;
            } else {
             return null;

            }
        }
    }

}
