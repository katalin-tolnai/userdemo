package com.example.demuser.controller;

import com.example.demuser.entity.User;
import com.example.demuser.repository.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// TODO KT 2021-03-14: create mvc test for the RestController
@RequestMapping("/api")
@RestController
public class UserRestController {
    private UserRepository userRepository;

    public UserRestController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public List<User> allUser() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFounException(id));
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/user")
    public User update(@RequestBody User userToSave) {
        return userRepository.findById(userToSave.getId())
                .map(userAlreadyInDb -> this.modifyUser(userToSave, userAlreadyInDb))
                .orElseThrow(() -> new IllegalArgumentException(""));
    }

    private User modifyUser(User userToSave, User userAlreadyInDb) {
        BeanUtils.copyProperties(userToSave, userAlreadyInDb, "id");
        userRepository.save(userAlreadyInDb);
        return userAlreadyInDb;
    }

    // TODO KT 2021-03-14:  path variable is not defined in the mapping. It can not work like this
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable String id)
    {
        // TODO KT 2021-03-14: check the status code if UserNotFounException gets thrown. It should be 404
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFounException(id));
        userRepository.delete(user);
    }
}
