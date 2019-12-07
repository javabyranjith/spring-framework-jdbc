package jbr.springjdbc.derby.crud.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import jbr.springjdbc.derby.crud.model.User;

public class UserDaoImpl implements UserDao {

  private JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void register(User user) {
    String query = "INSERT INTO users VALUES (?,?,?,?,?)";

    jdbcTemplate.update(query,
        new Object[] { user.getName(), user.getAddress(), user.getEmail(), user.getUsername(), user.getPassword() });
  }

  @Override
  public List<User> getAllUsers() {
    List<User> users = new ArrayList<User>();

    List<Map<String, Object>> results = jdbcTemplate.queryForList("select * from users");
    for (Map<String, Object> rs : results) {
      User user = new User();

      user.setName(rs.get("name").toString());
      user.setAddress(rs.get("address").toString());
      user.setEmail(rs.get("email").toString());
      user.setUsername(rs.get("username").toString());

      users.add(user);
    }

    return users;
  }

  @Override
  public void modify(String name, String email) {
    String query = "UPDATE users SET email = ? WHERE name = ?";

    Object[] params = { email, name };
    int[] types = { Types.VARCHAR, Types.VARCHAR };

    int rows = jdbcTemplate.update(query, params, types);
    System.out.println(rows + " row updated.");
  }

  @Override
  public User getUserByName(String name) {
    List<User> users = new ArrayList<User>();

    List<Map<String, Object>> results = jdbcTemplate.queryForList("select * from users where name = '" + name + "'");
    for (Map<String, Object> rs : results) {
      User user = new User();

      user.setName(rs.get("name").toString());
      user.setAddress(rs.get("address").toString());
      user.setEmail(rs.get("email").toString());
      user.setUsername(rs.get("username").toString());

      users.add(user);
    }

    return null != users.get(0) ? users.get(0) : null;
  }

  @Override
  public void delete(String name) {
    String query = "DELETE FROM users WHERE name=?";
    jdbcTemplate.update(query, name);
  }

}
