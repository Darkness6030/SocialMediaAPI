package com.avdeyy.SocialMediaApi.controller;

import com.avdeyy.SocialMediaApi.entity.User;
import com.avdeyy.SocialMediaApi.service.FollowingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequiredArgsConstructor
@Slf4j
@EnableWebMvc
@EnableWebSecurity
@EnableGlobalAuthentication
public class FollowingController {
    private final FollowingService followingService;

    @PostMapping("/subscribe/{currentUser}/{user}")
    public ResponseEntity<?> subscribe(@PathVariable User currentUser , @PathVariable User user) {
        followingService.subscribe(currentUser, user);
        return  ResponseEntity.ok(HttpStatus.CREATED);
        // с 2 юзерами работает, но только в 1 сторону, надо это поменять и понять как работать с principal, и как работать с 2RequestBody
    }

    @PostMapping("/unsubscribe/{currentUser}/{user}")
    public ResponseEntity<?> unsubscribe(@PathVariable User currentUser, @PathVariable User user){
        followingService.unsubscribe(currentUser,user);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
