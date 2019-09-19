package com.consulteer.facebook.service.services;

import com.consulteer.facebook.entity.User;

import java.util.Optional;


public interface UserService {

    User create(User user);

    Optional<User> findOne(Long id);

    void deleteUser(Long userId);

}
