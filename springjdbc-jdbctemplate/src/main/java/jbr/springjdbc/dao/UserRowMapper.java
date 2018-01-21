package jbr.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jbr.springjdbc.model.User;

public class UserRowMapper implements RowMapper<User> {

  @Override
  public User mapRow(ResultSet rs, int arg1) throws SQLException {

    User user = new User();
    user.setName(rs.getString("name"));
    user.setAddress(rs.getString("address"));
    user.setEmail(rs.getString("email"));
    user.setUsername(rs.getString("username"));
    user.setCity(rs.getString("city"));
    user.setPhone(rs.getString("phone"));
    user.setCountry(rs.getString("country"));

    return user;
  }

}
