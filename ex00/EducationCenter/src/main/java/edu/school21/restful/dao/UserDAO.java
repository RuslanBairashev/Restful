package edu.school21.restful.dao;

import edu.school21.restful.model.Usr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Usr> index() {
        return jdbcTemplate.query("SELECT *  FROM Usr",
                new BeanPropertyRowMapper<>(Usr.class));
    }
}
