package jbr.springdb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import jbr.springdb.model.User;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

  public List<User> getAllUsers() {
    List<User> users = new ArrayList<User>();

    List<Map<String, Object>> results = getJdbcTemplate().queryForList("select * from users");
    for (Map<String, Object> rs : results) {
      User user = new User();

      user.setUserId(Integer.valueOf(rs.get("user_id").toString()));
      user.setFirstname(String.valueOf(rs.get("first_name")));
      user.setLastname(String.valueOf(rs.get("last_name")));
      user.setEmail(String.valueOf(rs.get("email")));
      user.setPhone(Integer.valueOf(rs.get("phone").toString()));

      users.add(user);
    }

    return users;
  }

  public User getUserById(Integer id) {

    User user = (User) getJdbcTemplate().queryForObject("select * from users where user_id=" + id, new UserMapper());

    return user;
  }

  private class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int arg1) throws SQLException {
      User user = new User();

      user.setUserId(rs.getInt("user_id"));
      user.setFirstname(rs.getString("first_name"));
      user.setLastname(rs.getString("last_name"));
      user.setEmail(rs.getString("email"));
      user.setPhone(rs.getInt("phone"));

      return user;
    }

  }

  public int updateUser(User user) {
    return 0;
  }

  public int addUser(List<User> users) {
    return 0;
  }
}
