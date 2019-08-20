package com.consulteer.facebook.service;

import com.consulteer.facebook.entity.User;
import com.consulteer.facebook.exceptions.BadRequesException;
import com.consulteer.facebook.exceptions.NotFoundException;
import com.consulteer.facebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User input) {
        if (!isValid(input)) {
            throw new BadRequesException("Bad request");
        }
        String email = input.getEmail();
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            return userRepository.save(input);
        }
        return null;
    }

    @Override
    public Optional<User> findOne(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser;
        }
        throw new NotFoundException("User not found");
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (isValid(optionalUser.get())) {
            userRepository.deleteById(userId);
        }
    }

    private boolean isValid(User user) {
        if (user == null || user.getEmail() == null || user.getEmail().isEmpty()
                || user.getPassword() == null || user.getPassword().isEmpty()) {
            return false;
        }

        return true;
    }
}