package com.avdeyy.SocialMediaApi.dto;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
}
