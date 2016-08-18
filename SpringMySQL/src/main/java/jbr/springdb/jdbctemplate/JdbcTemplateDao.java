package jbr.springdb.jdbctemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import jbr.springdb.model.User;

public class JdbcTemplateDao {

  private DataSource datasource;
  private JdbcTemplate jdbcTemplate;

  public void setDatasource(DataSource datasource) {
    this.datasource = datasource;
  }

  public List<User> getAllUsers() {
    jdbcTemplate = new JdbcTemplate(datasource);

    List<User> results = jdbcTemplate.query("select * from users", new BeanPropertyRowMapper(User.class));

    return results;
  }

  public List<User> getUsers1() {
    List<User> users = new ArrayList<User>();
    jdbcTemplate = new JdbcTemplate(datasource);

    List<Map<String, Object>> results = jdbcTemplate.queryForList("select * from users");

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
