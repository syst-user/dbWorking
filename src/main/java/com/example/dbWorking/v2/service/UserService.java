package com.example.dbWorking.v2.service;

import com.example.dbWorking.v2.entitie.User;

import java.util.List;

public interface UserService {

    User getUser(Integer id);

    List<User> getAllUsers();

    User createUser(User user);

    User putUser(Integer id, User user);

    void deleteUser(Integer id);

    User findFirstByFirstName(String filter);

    List<User> findByMail(String filter);

    List<User> findByMail2(String filter);

    List<User> findByLastName(String filter);

    List<User> findByFirstName(String filter);

    List<User> findByFirstName2(String filter);
}
