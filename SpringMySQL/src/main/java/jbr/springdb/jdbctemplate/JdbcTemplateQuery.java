package jbr.springdb.jdbctemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import jbr.springdb.model.User;

public class JdbcTemplateQuery {

  private DataSource datasource;
  private JdbcTemplate jdbcTemplate;

  public void setDatasource(DataSource datasource) {
    this.datasource = datasource;
  }

  public List<User> queryWithBeanPropertyRowMapper() {
    jdbcTemplate = new JdbcTemplate(datasource);
    List<User> results = jdbcTemplate.query("select * from users", new BeanPropertyRowMapper(User.class));

    return results;
  }

  public User queryPreparedStatementCreator(final String firstname) {
    jdbcTemplate = new JdbcTemplate(datasource);
    User result = jdbcTemplate.query(new PreparedStatementCreator() {

      public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

        PreparedStatement stmt = conn.prepareStatement("select * from users where firstname = ?",
            new String[] { "user_id", "firstname" });

        return stmt;
      }
    }, new PreparedStatementSetter() {
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, firstname);
      }
    }, new ResultSetExtractor<User>() {
      public User extractData(ResultSet rs) throws SQLException, DataAccessException {
        User user = new User();
        if (rs.next()) {
          user.setUserId(rs.getString("user_id"));
          user.setFirstname(rs.getString("firstname"));
        }

        return user;
      }
    });

    return result;
  }

}
