package com.avdeyy.SocialMediaApi.service;

import com.avdeyy.SocialMediaApi.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;
import java.util.function.Consumer;


@Service
@RequiredArgsConstructor
public class FollowingService {
    private final UserService userService;

    public ResponseEntity<?> subscribe(Principal principal, User user) {
        return userService.findByPrincipal(principal, currentUser -> {
            user.getFollowers().add(currentUser);
            userService.getUserRepository().save(currentUser);

            return ResponseEntity.ok(HttpStatus.OK);
        });
    }

    public ResponseEntity<?> unsubscribe(Principal principal, User user) {
        return userService.findByPrincipal(principal, currentUser -> {
            user.getFollowers().remove(currentUser);
            userService.getUserRepository().save(currentUser);

            return ResponseEntity.ok(HttpStatus.OK);
        });
    }
}