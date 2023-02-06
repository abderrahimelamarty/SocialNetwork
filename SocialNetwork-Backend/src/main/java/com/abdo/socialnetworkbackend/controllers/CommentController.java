package com.abdo.socialnetworkbackend.controllers;

import com.abdo.socialnetworkbackend.entities.Comment;
import com.abdo.socialnetworkbackend.entities.CommentPostRequestEntity;
import com.abdo.socialnetworkbackend.entities.IdObjectEntity;
import com.abdo.socialnetworkbackend.entities.Post;
import com.abdo.socialnetworkbackend.services.CommentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/insertcomment")
    public ResponseEntity<Post> insertComment(@RequestBody CommentPostRequestEntity postedComment) {
        Comment inputComment = postedComment.getCommentEntity();
        IdObjectEntity inputPostId = postedComment.getPostId();
        return new ResponseEntity<Post>(commentService.insertComment(inputComment, inputPostId.getId()), HttpStatus.OK);
    }

    @PostMapping("/getcomments") 
    public ResponseEntity<List<Comment>> getComments(@RequestBody IdObjectEntity inputPostId) {
        return new ResponseEntity<List<Comment>>(commentService.getComments(inputPostId.getId()), HttpStatus.OK);
    }
}
