package com.example.dbWorking.service.impl;

import com.example.dbWorking.entitie.User;
import com.example.dbWorking.mapper.UserMapper;
import com.example.dbWorking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@PropertySource("classpath:sql.properties")
public class UserServiceNewImpl implements UserService {

    @Value("${user.get}")
    private String GET_USER;

    @Value("${user.get.all}")
    private String GET_ALL_USERS;

    @Value("${user.insert}")
    private String INSERT_USER;

    @Value("${user.update}")
    private String UPDATE_USER;

    @Value("${user.delete}")
    private String DELETE_USER;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public User getUser(Integer id) {
        return namedParameterJdbcTemplate.query(GET_USER, getIdSqlParameter(id), new UserMapper()
        ).stream().findFirst().orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return namedParameterJdbcTemplate.query(GET_ALL_USERS, new UserMapper());
    }

    @Override
    public User createUser(User user) {
        namedParameterJdbcTemplate.update(INSERT_USER, getAllSqlParameters(user));
        return user;
    }

    @Override
    public User putUser(Integer id, User user) {
        namedParameterJdbcTemplate.update(UPDATE_USER, getAllSqlParameters(user));
        return getUser(id);
    }

    @Override
    public void deleteUser(Integer id) {
        namedParameterJdbcTemplate.update(DELETE_USER, getIdSqlParameter(id));
    }

    private MapSqlParameterSource getAllSqlParameters(User user) {
        return new MapSqlParameterSource()
                .addValue("id", user.getId())
                .addValue("firstName", user.getFirstName())
                .addValue("lastName", user.getLastName())
                .addValue("email", user.getEmail());
    }

    private MapSqlParameterSource getIdSqlParameter(Integer id) {
        return new MapSqlParameterSource()
                .addValue("id", id);
    }
}
