package jbr.springjdbc.dao;

import java.util.List;

import jbr.springjdbc.model.User;

public interface UserDao {

  void register(User user);

  List<User> getAllUsers();

  void modify(String name, String email);

  void delete(String name);

  User getUserByName(String name);

  User getUserByEmail(String email);

  User getUsersByPhone(String phone);

  List<User> getUsersByCity(String city);
  
  List<User> getUsersByCountry(String country);
}
