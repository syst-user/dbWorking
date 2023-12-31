package com.example.dbWorking.service;

import com.example.dbWorking.entitie.User;

import java.util.List;

public interface UserService {

    User getUser(Integer id);

    List<User> getAllUsers();

    User createUser(User user);

    User putUser(Integer id, User user);

    void deleteUser(Integer id);
}
