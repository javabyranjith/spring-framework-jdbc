package jbr.springdb.dao;

import java.util.List;

import jbr.springdb.model.User;

public interface UserDao {

	List<User> getAllUsers();

	User getUserById(Integer id);

	int updateUser(User user);

	int addUser(List<User> users);
}
