package jbr.springjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import jbr.springjdbc.model.User;

@Repository
public class JdbcTemplateDaoImpl implements JdbcTemplateDao {

  private JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int addUsingUpdate(User user) {
    String query = "INSERT INTO users VALUES (?,?,?,?,?,?,?,?,?)";

    return jdbcTemplate.update(query, new Object[] { user.getId(), user.getName(), user.getAddress(), user.getEmail(),
        user.getPhone(), user.getCity(), user.getCountry(), user.getUsername(), user.getPassword() });
  }

  @Override
  public int addUsingUpdatePrepStmtSetter(User user) {
    String query = "INSERT INTO users VALUES (?,?,?,?,?,?,?,?,?)";

    return jdbcTemplate.update(query, new PreparedStatementSetter() {

      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setInt(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getAddress());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getPhone());
        ps.setString(6, user.getCity());
        ps.setString(7, user.getCountry());
        ps.setString(8, user.getUsername());
        ps.setString(9, user.getPassword());
      }
    });
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
  public void updateUser(String name, String email) {
    String query = "UPDATE users SET email = ? WHERE name = ?";

    Object[] params = { email, name };
    int[] types = { Types.VARCHAR, Types.VARCHAR };

    int rows = jdbcTemplate.update(query, params, types);
    System.out.println(rows + " row updated.");
  }

  @Override
  public User getUserByName(String name) {
    List<User> users = new ArrayList<User>();

    // plain
    List<Map<String, Object>> results = jdbcTemplate.queryForList("SELECT * FROM users WHERE name = '" + name + "'");
    for (Map<String, Object> rs : results) {
      User user = new User();

      user.setName(rs.get("name").toString());
      user.setAddress(rs.get("address").toString());
      user.setEmail(rs.get("email").toString());
      user.setPhone(rs.get("phone").toString());
      user.setUsername(rs.get("username").toString());
      user.setCity(rs.get("city").toString());

      users.add(user);
    }

    return null != users.get(0) ? users.get(0) : null;
  }

  @Override
  public void deleteUser(String name) {
    String query = "DELETE FROM users WHERE name=?";
    jdbcTemplate.update(query, name);
  }

  @Override
  public User getUserByEmail(String email) {
    // using RowMapper
    String query = "SELECT * FROM users WHERE email = ?";
    User user = jdbcTemplate.query(query, new Object[] { email }, new UserRowMapper()).get(0);

    return user;
  }

  @Override
  public User getUsersByPhone(String phone) {
    // using BeanPropertyRowMapper
    String query = "SELECT * FROM users WHERE phone = ?";
    User user = jdbcTemplate.queryForObject(query, new Object[] { phone }, new BeanPropertyRowMapper<User>(User.class));

    return user;
  }

  @Override
  public List<User> getUsersByCity(final String city) {
    // using PreparedStatementSetter
    String query = "SELECT * FROM users WHERE city = ?";
    List<User> users = jdbcTemplate.query(query, new PreparedStatementSetter() {

      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, city);
      }
    }, new UserRowMapper());

    return users;
  }

  @Override
  public List<User> getUsersByCountry(final String country) {

    List<User> users = jdbcTemplate.query(new PreparedStatementCreator() {

      @Override
      public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
        return conn.prepareStatement("SELECT * FROM users where country=?");
      }
    }, new PreparedStatementSetter() {

      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, country);
      }
    }, new ResultSetExtractor<List<User>>() {

      @Override
      public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<User> list = new ArrayList<>();

        while (rs.next()) {
          User user = new User();
          user.setName(rs.getString("name"));
          user.setAddress(rs.getString("address"));
          user.setEmail(rs.getString("email"));
          user.setUsername(rs.getString("username"));
          user.setCity(rs.getString("city"));
          user.setPhone(rs.getString("phone"));
          user.setCountry(rs.getString("country"));

          list.add(user);
        }
        return list;
      }
    });

    return users;
  }

}
