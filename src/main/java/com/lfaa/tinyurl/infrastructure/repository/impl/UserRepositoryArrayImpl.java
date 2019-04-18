package com.lfaa.tinyurl.infrastructure.repository.impl;

import com.lfaa.tinyurl.domain.entity.User;
import com.lfaa.tinyurl.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryArrayImpl implements UserRepository {
    private List<User> userList = new ArrayList<>();
    private long INITIAL_USER_INDEX = 1;

    @Override
    public void save(User user) {
        user.setId(INITIAL_USER_INDEX++);
        this.userList.add(user);
    }

    @Override
    public List<User> findAll() {
        return this.userList;
    }

    @Override
    public Optional<User> findByUserId(Long userId) {
        return this.userList.stream().filter(u -> u.getId().equals(userId)).findAny();
    }

}
