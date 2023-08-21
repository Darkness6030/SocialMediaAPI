package com.avdeyy.SocialMediaApi.controller;


import com.avdeyy.SocialMediaApi.entity.Post;
import com.avdeyy.SocialMediaApi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post/{id}/remove")
    public ResponseEntity<?> removePost(@PathVariable Long id){
        return postService.deletePost(id);
    }
    @PostMapping("/post/add")
    public ResponseEntity<?> addPost(@RequestBody Post post){
        return postService.addPostToUser(post);
    }
    @PostMapping("/post/{id}/update")
    public ResponseEntity<?> updatePost(@PathVariable Long id) {
        return postService.updatePost(id);
    }
}
