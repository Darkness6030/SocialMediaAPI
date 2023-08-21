package com.avdeyy.SocialMediaApi.dto;
import com.avdeyy.SocialMediaApi.entity.User;
import lombok.Data;

import java.awt.*;

@Data
public class PostDto {
    private String header;

    private String text;
}
