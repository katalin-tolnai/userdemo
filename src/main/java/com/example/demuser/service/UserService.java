package com.example.demuser.service;

import com.example.demuser.entity.User;
import com.example.demuser.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User update(User userToSave) {
        Optional<User> userOptional = userRepository.findById(userToSave.getId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            BeanUtils.copyProperties(userToSave, user,"id");
            userRepository.save(user);
            return user;
        }

        return null;
    }
}
