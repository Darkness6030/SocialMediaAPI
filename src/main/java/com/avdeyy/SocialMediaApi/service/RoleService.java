package com.avdeyy.SocialMediaApi.service;

import com.avdeyy.SocialMediaApi.entity.Role;
import com.avdeyy.SocialMediaApi.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Optional<Role> getUserRole() {
        return roleRepository.findByName("USER");
    }
}
