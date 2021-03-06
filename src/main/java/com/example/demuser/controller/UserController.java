package com.example.demuser.controller;

import com.example.demuser.entity.User;
import com.example.demuser.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/user")
@RestController
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> allUser() {
        return (List<User>) userRepository.findAll();
    }

    public User findById(@PathVariable String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFounException(id));
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/modify")
    public User update(@RequestBody User userToSave) {
        Optional<User> userOptional = userRepository.findById(userToSave.getId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            BeanUtils.copyProperties(userToSave, user, "id");
            userRepository.save(user);
            return user;
        }

        return null;

    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFounException(id));
        userRepository.delete(user);
    }
}
