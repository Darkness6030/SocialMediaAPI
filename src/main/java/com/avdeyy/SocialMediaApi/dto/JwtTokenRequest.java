package com.avdeyy.SocialMediaApi.dto;

import lombok.Data;

@Data
public class JwtTokenRequest {
    private String username;
    private String password;
}
