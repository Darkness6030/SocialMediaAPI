package com.avdeyy.SocialMediaApi.service;

import com.avdeyy.SocialMediaApi.entity.User;
import com.avdeyy.SocialMediaApi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FollowingService {
    private final UserRepository userRepository;

    public void subscribe(User currentUser, User user) {
        user.getFollowers().add(currentUser);
        userRepository.save(currentUser);
    }

    public void unsubscribe(User currentUser, User user) {
        user.getFollowers().remove(currentUser);
        userRepository.save(currentUser);
    }

}
