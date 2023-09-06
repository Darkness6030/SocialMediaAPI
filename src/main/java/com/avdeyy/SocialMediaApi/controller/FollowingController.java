package com.avdeyy.SocialMediaApi.controller;

import com.avdeyy.SocialMediaApi.entity.User;
import com.avdeyy.SocialMediaApi.service.FollowingService;
import com.avdeyy.SocialMediaApi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@EnableWebMvc
@EnableWebSecurity
@EnableGlobalAuthentication
public class FollowingController {
    private final FollowingService followingService;
    private final UserService userService;

    @PostMapping("/subscribe/{user}")
    public ResponseEntity<?> subscribe(Principal principal, @PathVariable User user) {
        if (principal == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        Optional<User> currentUser = userService.findByUsername(principal.getName());
        if (currentUser.isEmpty())
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        followingService.subscribe(currentUser.get(), user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/unsubscribe/{user}")
    public ResponseEntity<?> unsubscribe(Principal principal, @PathVariable User user) {
        if (principal == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        Optional<User> currentUser = userService.findByUsername(principal.getName());
        if (currentUser.isEmpty())
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        followingService.unsubscribe(currentUser.get(), user);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}