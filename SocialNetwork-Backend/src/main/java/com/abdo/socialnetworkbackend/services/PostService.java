package com.abdo.socialnetworkbackend.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.abdo.socialnetworkbackend.entities.IdObjectEntity;
import com.abdo.socialnetworkbackend.entities.Post;
import com.abdo.socialnetworkbackend.entities.User;
import com.abdo.socialnetworkbackend.repository.PostRepository;
import com.abdo.socialnetworkbackend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private UserRepository userRepo;
    
    public Post insertPost(Post inputPost) {
        inputPost.setCreatedAt(Instant.now());
        Post post =postRepo.save(inputPost);
        return post;
    }

    public List<Post> findPostByUserId(IdObjectEntity inputUserId) {
        Optional<List<Post>> userPostsOpt = postRepo.findByUserIdOrderByCreatedAtDesc(inputUserId.getId());
        if (userPostsOpt.isEmpty()) {
            return null;
        } else {
            List<Post> userPosts = userPostsOpt.get();
            return userPosts;
        }
    }
    
//    public ResponseObjectService findPostByFollowing(IdObjectEntity inputUserId) {
//        ResponseObjectService responseObj = new ResponseObjectService();
//        Optional<User> optUser = userRepo.findById(inputUserId.getId());
//        if (optUser.isEmpty()) {
//            responseObj.setStatus("fail");
//            responseObj.setMessage("cannot find any post from user id: " + inputUserId.getId());
//            responseObj.setPayload(null);
//            return responseObj;
//        } else {
//            User user = optUser.get();
//            if (user.getFollowing() != null) {
//                // if user followed someone, get their ids
//                List<String> followingIds = new ArrayList<>();
//                for (String id : user.getFollowing()) {
//                    followingIds.add(id);
//                }
//                // based on these ids, get their equivalent posts
//                List<PostByFollowing> listPosts = new ArrayList<>();
//                for (String followingId : followingIds) {
//                    // get following user info based on Id
//                    User followingUser = new User();
//                    Optional<User> optFollowingUser = userRepo.findById(followingId);
//                    if (optFollowingUser.isPresent()) {
//                        followingUser = optFollowingUser.get();
//                    }
//
//                    followingUser.setPassword("");
//
//                    // get equivalent posts
//                    Optional<List<Post>> followingPostsOpt = postRepo.findByUserId(followingId);
//                    if (followingPostsOpt.isPresent()) {
//                        // if followed account has any post, collect them
//                        List<Post> followingPosts = followingPostsOpt.get();
//                        if (followingPosts != null) {
//                            for (Post item : followingPosts) {
//                                listPosts.add(new PostByFollowing(followingUser, item));
//                            }
//                        }
//                    }
//                }
//                Collections.sort(listPosts, (o1, o2) -> o2.getPost().getCreatedAt().compareTo(o1.getPost().getCreatedAt()));
//                responseObj.setStatus("success");
//                responseObj.setMessage("success");
//                responseObj.setPayload(listPosts);
//                return responseObj;
//            } else {
//                responseObj.setStatus("fail");
//                responseObj.setMessage("user id: " + inputUserId.getId() + " has empty following list");
//                responseObj.setPayload(null);
//                return responseObj;
//            }
//        }
//    }

    public Post updatePostByComment(Post inputPost) {
        Optional<Post> optPost = postRepo.findById(inputPost.getId());
        if (optPost.isEmpty()) {
           return null;
        } else {
            // inputPost.setCreatedAt(Instant.now());
           Post post= postRepo.save(inputPost);
            return post ;
        }
    }

   /* public Post updatePostByLove(DoubleIdObjectEntity doubleId) {
        // id 1 - post Id, id 2 - user who liked post

        Optional<Post> optPost = postRepo.findById(doubleId.getId1());
        if (optPost.isEmpty()) {
           return null;
        } else {
            Post targetPost = optPost.get();
            List<String> loveList = targetPost.getLove();
            if (loveList == null) {
                loveList = new ArrayList<>();
            }
            // love and unlove a post
            if (!loveList.contains(doubleId.getId2())) {
                loveList.add(doubleId.getId2());
            } else {
                loveList.remove(doubleId.getId2());
            }
            targetPost.setLove(loveList);
            Post post= postRepo.save(targetPost);
            return post;
        }
    }*/

    /*public ResponseObjectService updatePostByShare(DoubleIdObjectEntity doubleId) {
        // id 1 - post Id, id 2 - user who shared post
        ResponseObjectService responseObj = new ResponseObjectService();
        Optional<PostEntity> optPost = postRepo.findById(doubleId.getId1());
        if (optPost.isEmpty()) {
            responseObj.setStatus("fail");
            responseObj.setMessage("cannot find post id: " + doubleId.getId1());
            responseObj.setPayload(null);
            return responseObj;
        } else {
            PostEntity targetPost = optPost.get();
            List<String> shareList = targetPost.getShare();
            if (shareList == null) {
                shareList = new ArrayList<>();
            }
            // save id of user who shared the post then update post
            shareList.add(doubleId.getId2());
            targetPost.setShare(shareList);
            postRepo.save(targetPost);
            // update post list of user who shared the post
            targetPost.setUserId(doubleId.getId2());
            targetPost.setId(null);
            targetPost.setContent("Shared a post: " + targetPost.getContent());
            targetPost.setLove(new ArrayList<>());
            targetPost.setShare(new ArrayList<>());
            targetPost.setComment(new ArrayList<>());
            postRepo.save(targetPost);

            responseObj.setStatus("success");
            responseObj.setMessage("add a share to the target post id: " + targetPost.getId());
            responseObj.setPayload(targetPost);
            return responseObj;
        }
    }*/
}
