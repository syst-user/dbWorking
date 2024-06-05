package com.example.dbWorking.v2.service.impl;

import com.example.dbWorking.v2.entitie.User;
import com.example.dbWorking.v2.repository.UserRepository;
import com.example.dbWorking.v2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Integer id) {
        return userRepository.getById(Long.valueOf(id.toString()));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User putUser(Integer id, User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(Long.valueOf(id.toString()));
    }

    @Override
    public User findFirstByFirstName(String filter) {
        return userRepository.findFirstByFirstNameLike("%" + filter + "%");
    }

    @Override
    public List<User> findByMail(String filter) {
        return userRepository.findByMail("%" + filter + "%");
    }

    @Override
    public List<User> findByMail2(String filter) {
        return userRepository.findByMail2("%" + filter + "%");
    }

    @Override
    public List<User> findByLastName(String filter) {
        return userRepository.findByLastName("%" + filter + "%");
    }

    @Override
    public List<User> findByFirstName(String filter) {
        return userRepository.findByFirstName("%" + filter + "%");
    }

    @Override
    public List<User> findByFirstName2(String filter) {
        return userRepository.findByFirstName2(filter);
    }

    @Override
    public List<User> findAllByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<User> findAllByFirstNameAndLastName2(String firstName, String lastName) {
        return userRepository.findAllByFirstNameAndLastName2(firstName, lastName);
    }
}
