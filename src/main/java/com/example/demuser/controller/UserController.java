package com.example.demuser.controller;

import com.example.demuser.entity.User;
import com.example.demuser.repository.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// TODO KT 2021-03-14: rename to UserRestController
// TODO KT 2021-03-14: create mvc test for the RestController
@RequestMapping("/api")
@RestController
public class UserController
{
    private UserRepository userRepository;

    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    // TODO KT 2021-03-14:  rename mapping to "/user"
    @GetMapping("/users")
    public List<User> allUser()
    {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id)
    {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFounException(id));
    }

    // TODO KT 2021-03-14:  rename mapping to "/user"
    @PostMapping("/create")
    public User create(@RequestBody User user)
    {
        return userRepository.save(user);
    }

    // TODO KT 2021-03-14:  rename mapping to "/user"
    @PutMapping("/modify")
    public User update(@RequestBody User userToSave)
    {
        Optional<User> userOptional = userRepository.findById(userToSave.getId());
        if (userOptional.isPresent())
        {
            User user = userOptional.get();
            BeanUtils.copyProperties(userToSave, user, "id");
            userRepository.save(user);
            return user;
        }

        return null;

    }

    // TODO KT 2021-03-14:  rename mapping to "/user"
    // TODO KT 2021-03-14:  path variable is not defined in the mapping. It can not work like this
    @DeleteMapping("/delete")
    public void delete(@PathVariable String id)
    {
        // TODO KT 2021-03-14: check the status code if UserNotFounException gets thrown. It should be 404
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFounException(id));
        userRepository.delete(user);
    }
}
