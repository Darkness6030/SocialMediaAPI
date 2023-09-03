package com.avdeyy.SocialMediaApi.service;

import com.avdeyy.SocialMediaApi.entity.Post;
import com.avdeyy.SocialMediaApi.repository.PostRepository;
import com.avdeyy.SocialMediaApi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    private final UserRepository userRepository;


    public ResponseEntity<?> addPostToUser(@RequestBody Post post) {
        post.setHeader(post.getHeader());
        post.setText(post.getText());
        postRepository.save(post);
        return  ResponseEntity.ok(HttpStatus.OK);
    }
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<?> updatePost(@PathVariable Long id) { // С айдишником все нормально, разобраться почему не заменяет данные в базе
        Post post = postRepository.findById(id).orElseThrow();
        post.setHeader(post.getHeader());
        post.setText(post.getText());
        postRepository.save(post);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
