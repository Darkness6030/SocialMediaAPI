package com.avdeyy.SocialMediaApi.controller;

import com.avdeyy.SocialMediaApi.dto.JwtTokenRequest;
import com.avdeyy.SocialMediaApi.dto.UserCustomDto;
import com.avdeyy.SocialMediaApi.dto.UserDto;
import com.avdeyy.SocialMediaApi.entity.User;
import com.avdeyy.SocialMediaApi.exeption.AuthError;
import com.avdeyy.SocialMediaApi.service.JwtAuthService;
import com.avdeyy.SocialMediaApi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final JwtAuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtTokenRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(@RequestBody UserDto registrationUserDto) {
        return authService.createNewUser(registrationUserDto);
    }
}
