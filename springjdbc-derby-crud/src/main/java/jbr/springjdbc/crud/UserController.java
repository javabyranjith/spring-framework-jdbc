package jbr.springjdbc.crud;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jbr.springjdbc.crud.dao.UserDao;
import jbr.springjdbc.crud.model.User;

public class UserController {
  public UserDao userDao;

  public static void main(String[] args) {
    ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("springjdbc-crud-beans.xml");
    UserController userController = (UserController) appContext.getBean("userController");
    //userController.register();
    userController.getAllUsers();
    // userController.modify();
    // userController.delete();
    appContext.close();
  }

  public void register() {
    User user = new User();
    user.setName("Sekar");
    user.setAddress("Chennai1");
    user.setEmail("sek@gmail.com");
    user.setUsername("sekar");
    user.setPassword("chinn");

    userDao.register(user);
  }

  public void getAllUsers() {
    List<User> users = userDao.getAllUsers();
    for (User user : users) {
      System.out.println("Name: " + user.getName());
    }
  }

  public void modify() {
    User user = userDao.getUserByName("Ranjith");
    System.out.println("Current Email: " + user.getEmail());
    userDao.modify("Ranjith", "ranjithsekar@gmail.com");
    user = userDao.getUserByName("Ranjith");
    System.out.println("Updated Email: " + user.getEmail());
  }

  public void delete() {
    userDao.delete("Ranjith");
    getAllUsers();
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
}
