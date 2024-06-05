package com.example.dbWorking.v1.controller;

import com.example.dbWorking.v1.entitie.User;
import com.example.dbWorking.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/user")
public class UserController {

    @Autowired
    //@Qualifier("userServiceNewImpl")
    @Qualifier("userServiceImpl")
    UserService userService;

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return createdUser;
    }

    @PutMapping("{id}")
    public User putUser(@PathVariable("id") Integer id, @RequestBody User user) {
        User updatedUser = userService.putUser(id, user);
        return updatedUser;
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }

}
