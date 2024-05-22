package com.spring.security.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.spring.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public User findByName(String username) {
	    String sql = "SELECT * FROM users WHERE username=?";
	    RowMapper<User> mapper = new RowMapper<User>() {
	        @Override
	        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	            User user = new User();
	            user.setUsername(rs.getString("username"));
	            user.setPassword(rs.getString("password"));
	            return user;
	        }
	    };
	    // Pass the parameters separately from the SQL query
	    User user = jdbcTemplate.queryForObject(sql, new Object[]{username}, mapper);
	    return user;
	}

}
