package com.lfaa.tinyurl.infrastructure.repository;

import com.lfaa.tinyurl.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    List<User> findAll();
    Optional<User> findByUserId(Long userId);
}
