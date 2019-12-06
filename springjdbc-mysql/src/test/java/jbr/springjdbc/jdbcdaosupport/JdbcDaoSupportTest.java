package jbr.springjdbc.jdbcdaosupport;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jbr.springdb.jdbcdaosupport.JdbcDaoSupportDao;
import jbr.springdb.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/jdbc-dao-support-beans.xml" })
public class JdbcDaoSupportTest {

  @Autowired
  private JdbcDaoSupportDao dao;

  @Test
  public void testJdbcDaoSupport() {
    User user2 = dao.getUsers().get(2);
    System.out.println(user2.toString());
    Assert.assertEquals("Sachin", user2.getFirstname());
    Assert.assertEquals("sachin@gmail.com", user2.getEmail());
  }

}
