package jbr.springjdbc.dao;

import java.util.List;

import jbr.springjdbc.model.User;

public interface JdbcTemplateDao {

  int addUsingUpdate(User user);

  int addUsingUpdatePrepStmtSetter(User user);

  List<User> getAllUsers();

  void updateUser(String name, String email);

  void deleteUser(String name);

  User getUserByName(String name);

  User getUserByEmail(String email);

  User getUsersByPhone(String phone);

  List<User> getUsersByCity(String city);

  List<User> getUsersByCountry(String country);
}
