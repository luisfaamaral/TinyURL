package com.lfaa.tinyurl.domain.service.impl;

import com.lfaa.tinyurl.domain.entity.User;
import com.lfaa.tinyurl.domain.service.UserService;
import com.lfaa.tinyurl.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean isValidUser(Long userId) {
        return userRepository.findByUserId(userId).isPresent();
    }
}
