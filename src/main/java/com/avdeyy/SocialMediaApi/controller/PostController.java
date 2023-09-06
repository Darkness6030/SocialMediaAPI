package com.avdeyy.SocialMediaApi.controller;


import com.avdeyy.SocialMediaApi.entity.Post;
import com.avdeyy.SocialMediaApi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post/{id}/remove")
    public ResponseEntity<?> removePost(Principal principal, @PathVariable Long id) {
        return postService.deletePost(principal, id);
    }

    @PostMapping("/post/add")
    public ResponseEntity<?> addPost(Principal principal, @RequestBody Post post) {
        return postService.addPostToUser(principal, post);
    }

    @PostMapping("/post/{id}/update")
    public ResponseEntity<?> updatePost(Principal principal, @PathVariable Long id) {
        return postService.updatePost(principal, id);
    }
}