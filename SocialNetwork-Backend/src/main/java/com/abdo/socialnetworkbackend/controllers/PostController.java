package com.abdo.socialnetworkbackend.controllers;

import com.abdo.socialnetworkbackend.entities.IdObjectEntity;
import com.abdo.socialnetworkbackend.entities.Post;
import com.abdo.socialnetworkbackend.services.PostService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/Posts")
    public ResponseEntity<Object> insertPost(@RequestBody Post inputPost) {
        System.out.println(inputPost);
        return new ResponseEntity<Object>(postService.insertPost(inputPost), HttpStatus.OK);
    }
    
    @PostMapping("/myposts")
    public ResponseEntity<List<Post>> findPostByUserId(@RequestBody IdObjectEntity inputUserId) {
        return new ResponseEntity<List<Post>>(postService.findPostByUserId(inputUserId), HttpStatus.OK);
    }

//    @PostMapping("/followingposts")
//    public ResponseEntity<ResponseObjectService> findPostByFollowing(@RequestBody IdObjectEntity inputUserId) {
//        return new ResponseEntity<ResponseObjectService>(postService.findPostByFollowing(inputUserId), HttpStatus.OK);
//    }

    // currently not in use, post is update via comment controller
    // @PutMapping("/updatebycomment")
    // public ResponseEntity<ResponseObjectService> updateByComment(@RequestBody PostEntity inputPost) {
    //     return new ResponseEntity<ResponseObjectService>(postService.updatePostByComment(inputPost), HttpStatus.OK);
    // }

   /* @PostMapping("/lovepost")
    public ResponseEntity<ResponseObjectService> lovePost(@RequestBody DoubleIdObjectEntity doubleId) {
        return new ResponseEntity<ResponseObjectService>(postService.updatePostByLove(doubleId), HttpStatus.OK);
    }

    @PostMapping("/sharepost")
    public ResponseEntity<ResponseObjectService> sharePost(@RequestBody DoubleIdObjectEntity doubleId) {
        return new ResponseEntity<ResponseObjectService>(postService.updatePostByShare(doubleId), HttpStatus.OK);
    }*/
}
