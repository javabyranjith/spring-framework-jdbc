package jbr.springjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyExample {

  public static void main(String[] args) throws SQLException {
    String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    String dbName = "/jbr/spring_jdbc";
    String connectionURL = "jdbc:derby:" + dbName + ";user=spring;password=jdbc";
    Connection connection = null;

    try {
      Class.forName(driver);
      connection = DriverManager.getConnection(connectionURL);
      Statement statement = connection.createStatement();

      // INSERT
      int result = statement.executeUpdate("INSERT INTO users VALUES(4,'Bose','Subash','bose@gmail.com',96000)");
      System.out.println("Updated " + result + " rows");

      // SELECT
      ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
      while (resultSet.next()) {
        String first = resultSet.getString("FIRST_NAME");
        String last = resultSet.getString("LAST_NAME");
        System.out.println("Name: " + first + " " + last);
      }
      resultSet.close();
    } catch (Throwable e) {
      e.printStackTrace();
    } finally {
      connection.close();
    }
  }
}