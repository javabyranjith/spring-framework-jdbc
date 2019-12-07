package jbr.springjdbc.derby.crud.dao;

import java.util.List;

import jbr.springjdbc.derby.crud.model.User;

public interface UserDao {

  void register(User user);

  List<User> getAllUsers();

  void modify(String name, String email);

  void delete(String name);

  User getUserByName(String name);
}
