package jbr.springdb.jdbcdaosupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import jbr.springdb.model.User;

public class JdbcDaoSupportDao extends JdbcDaoSupport {

  public List<User> getUsers() {
    List<User> users = new ArrayList<User>();

    List<Map<String, Object>> results = getJdbcTemplate().queryForList("select * from users");
    for (Map<String, Object> rs : results) {
      User user = new User();

      user.setUserId(String.valueOf(rs.get("user_id")));
      user.setUserType(String.valueOf(rs.get("user_type")));
      user.setFirstname(String.valueOf(rs.get("firstname")));
      user.setLastname(String.valueOf(rs.get("lastname")));
      user.setEmail(String.valueOf(rs.get("email")));
      user.setAddress(String.valueOf(rs.get("address")));
      user.setPhone(Integer.valueOf(rs.get("phone").toString()));

      users.add(user);
    }

    return users;
  }
}
