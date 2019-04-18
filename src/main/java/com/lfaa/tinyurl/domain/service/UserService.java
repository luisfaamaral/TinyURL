package com.lfaa.tinyurl.domain.service;

import com.lfaa.tinyurl.domain.entity.User;

public interface UserService {
    public void save(User user);
    boolean isValidUser(Long userId);
}
