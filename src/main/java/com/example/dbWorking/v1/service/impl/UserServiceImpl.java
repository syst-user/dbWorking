package com.example.dbWorking.v1.service.impl;

import com.example.dbWorking.v1.entitie.User;
import com.example.dbWorking.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public User getUser(Integer id) {
        MapSqlParameterSource sqlParameters = new MapSqlParameterSource()
                .addValue("id", id);
        String query = "select id, firstName, lastName, email from users where id = :id";
        return namedParameterJdbcTemplate.query(query, sqlParameters, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setEmail(rs.getString("email"));
            return user;
        }
        ).stream().findFirst().orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        String query = "select id, firstName, lastName, email from users";
        return namedParameterJdbcTemplate.query(query, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setEmail(rs.getString("email"));
            return user;
        });
    }

    @Override
    public User createUser(User user) {
        String query = "insert into users(firstName, lastName, email) values (:firstName, :lastName, :email)";
        namedParameterJdbcTemplate.update(query, getAllSqlParameters(user));
        return user;
    }

    @Override
    public User putUser(Integer id, User user) {
        String query = "UPDATE users SET firstname = :firstName, lastname = :lastName, email = :email WHERE id = :id";
        namedParameterJdbcTemplate.update(query, getAllSqlParameters(user));
        return getUser(id);
    }

    @Override
    public void deleteUser(Integer id) {
        MapSqlParameterSource sqlParameters = new MapSqlParameterSource()
                .addValue("id", id);
        String query = "DELETE FROM users WHERE id = :id";
        namedParameterJdbcTemplate.update(query, sqlParameters);
    }

    private MapSqlParameterSource getAllSqlParameters(User user) {
        return new MapSqlParameterSource()
                .addValue("id", user.getId())
                .addValue("firstName", user.getFirstName())
                .addValue("lastName", user.getLastName())
                .addValue("email", user.getEmail());
    }
}
