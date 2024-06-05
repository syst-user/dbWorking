package com.example.dbWorking.v2.controller;

import com.example.dbWorking.v2.entitie.User;
import com.example.dbWorking.v2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v2/user")
public class UserControllerV2 {

    @Autowired
    //@Qualifier("userServiceJpaImpl")
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

    @GetMapping("/findFirstByFirstName/{filter}")
    public User findFirstByFirstName(@PathVariable("filter") String filter) {
        User result = userService.findFirstByFirstName(filter);
        return result;
    }

    @GetMapping("/findByMail/{filter}")
    public List<User> findByMail(@PathVariable("filter") String filter) {
        List<User> result = userService.findByMail(filter);
        return result;
    }

    @GetMapping("/findByMail2/{filter}")
    public List<User> findByMail2(@PathVariable("filter") String filter) {
        List<User> result = userService.findByMail2(filter);
        return result;
    }

    @GetMapping("/findByLastName/{filter}")
    public List<User> findByLastName(@PathVariable("filter") String filter) {
        List<User> result = userService.findByLastName(filter);
        return result;
    }

    @GetMapping("/findByFirstName/{filter}")
    public List<User> findByFirstName(@PathVariable("filter") String filter) {
        List<User> result = userService.findByFirstName(filter);
        return result;
    }

    @GetMapping("/findByFirstName2/{filter}")
    public List<User> findByFirstName2(@PathVariable("filter") String filter) {
        List<User> result = userService.findByFirstName2(filter);
        return result;
    }

    @GetMapping("/findAllByFirstNameAndLastName")
    public List<User> findAllByFirstNameAndLastName(@RequestParam("firstName") String firstName,
                                       @RequestParam("lastName") String lastName) {
        List<User> result = userService.findAllByFirstNameAndLastName(firstName, lastName);
        return result;
    }

    @GetMapping("/findAllByFirstNameAndLastName2")
    public List<User> findAllByFirstNameAndLastName2(@RequestParam("firstName") String firstName,
                                       @RequestParam("lastName") String lastName) {
        List<User> result = userService.findAllByFirstNameAndLastName2(firstName, lastName);
        return result;
    }
}
