package jbr.springdb;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jbr.springdb.dao.UserDao;

public class H2DbTest {
  ApplicationContext ctx;
  UserDao userDao;

  @Before
  public void setUp() throws Exception {
    ctx = new ClassPathXmlApplicationContext("config/h2db-beans.xml");
    userDao = (UserDao) ctx.getBean("userDao");
  }

  @Test
  public void testGetAllUsers() {
    System.out.println(userDao.getAllUsers().get(1).getFirstname() + " " + userDao.getAllUsers().get(1).getEmail());
    Assert.assertEquals("Manoj", userDao.getAllUsers().get(1).getFirstname());
    Assert.assertEquals("manoj@gmail.com", userDao.getAllUsers().get(1).getEmail());
  }

  @Test
  public void testGetUserById() {
    System.out.println(userDao.getUserById(2).getFirstname());
    Assert.assertEquals("Manoj", userDao.getUserById(2).getFirstname());
  }

}
