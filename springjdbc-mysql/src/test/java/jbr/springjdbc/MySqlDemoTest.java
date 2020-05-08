package jbr.springjdbc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jbr.springjdbc.dao.NonJdbcTemplateDao;
import jbr.springjdbc.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring-db-beans.xml" })
public class MySqlDemoTest {

  @Autowired
  private NonJdbcTemplateDao dao;

  @Test
  public void testNonJdbcTemplate() {
    User user1 = dao.getUsers().get(0);
    System.out.println(user1.toString());
    Assert.assertEquals("AD001", user1.getUserId());
    Assert.assertEquals("Ranjith", user1.getFirstname());
  }

}
