package jbr.springjdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jbr.springjdbc.model.User;

public class NonJdbcTemplateDao {

  private DataSource datasource;

  public void setDatasource(DataSource datasource) {
    this.datasource = datasource;
  }

  public List<User> getUsers() {
    List<User> users = new ArrayList<User>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = datasource.getConnection();
      stmt = con.createStatement();
      rs = stmt.executeQuery("select * from users");

      while (rs.next()) {
        User user = new User();

        user.setUserId(rs.getString("user_id"));
        user.setUserType(rs.getString("user_type"));
        user.setFirstname(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));
        user.setEmail(rs.getString("email"));
        user.setAddress(rs.getString("address"));
        user.setPhone(rs.getInt("phone"));

        users.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (null != con) {
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }

      if (null != stmt) {
        try {
          stmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }

      if (null != rs) {
        try {
          rs.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }

    return users;
  }

}
