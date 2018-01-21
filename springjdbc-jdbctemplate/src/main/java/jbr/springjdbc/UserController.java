package jbr.springjdbc;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jbr.springjdbc.dao.UserDao;
import jbr.springjdbc.model.User;

public class UserController {
  public UserDao userDao;

  public static void main(String[] args) {
    ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("jdbctemplate-beans.xml");
    UserController userController = (UserController) appContext.getBean("userController");

    //userController.register();
    userController.getAllUsers();

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

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
}
