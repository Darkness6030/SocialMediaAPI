package com.avdeyy.SocialMediaApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCustomDto {
    private Long id;
    private String email;
    private String username;

}
