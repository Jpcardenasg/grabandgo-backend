package com.grabandgo.grabandgo_backend.user.application;

import java.util.List;

import com.grabandgo.grabandgo_backend.user.domain.User;

/**
 * UserService
 */
public interface UserService {

    User saveUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    List<User> findAll();

}