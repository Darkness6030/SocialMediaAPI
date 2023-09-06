package com.avdeyy.SocialMediaApi.service;

import com.avdeyy.SocialMediaApi.entity.Post;
import com.avdeyy.SocialMediaApi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public ResponseEntity<?> addPostToUser(Principal principal, @RequestBody Post post) {
        return userService.findByPrincipal(principal, currentUser -> {
            // TODO использовать здесь этого юзера, например присваивать пост юзеру
            post.setHeader(post.getHeader());
            post.setText(post.getText());
            postRepository.save(post);

            return ResponseEntity.ok(HttpStatus.OK);
        });
    }

    public ResponseEntity<?> deletePost(Principal principal, @PathVariable Long id) {
        return userService.findByPrincipal(principal, currentUser -> {
            // TODO использовать здесь этого юзера, например проверять, принадлежит ли пост юзеру
            postRepository.deleteById(id);

            return ResponseEntity.ok(HttpStatus.OK);
        });
    }

    public ResponseEntity<?> updatePost(Principal principal, @PathVariable Long id) { // С айдишником все нормально, разобраться почему не заменяет данные в базе
        return userService.findByPrincipal(principal, currentUser -> {
            // TODO использовать здесь этого юзера, например проверять, принадлежит ли пост юзеру
            Post post = postRepository.findById(id).orElseThrow();
            post.setHeader(post.getHeader());
            post.setText(post.getText());
            postRepository.save(post);

            return ResponseEntity.ok(HttpStatus.OK);
        });
    }
}