package jbr.springjdbc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jbr.springdb.dao.NonJdbcTemplateDao;

public class MySqlDemoTest {
  ApplicationContext ctx;

  @Before
  public void setUp() throws Exception {
    ctx = new ClassPathXmlApplicationContext("config/spring-db-beans.xml");
  }

  @Test
  public void testNonJdbcTemplate() {
    NonJdbcTemplateDao dao = (NonJdbcTemplateDao) ctx.getBean("nonJdbcTemplateDao");
    Assert.assertEquals("AD001", dao.getUsers().get(0).getUserId());
    Assert.assertEquals("Ranjith", dao.getUsers().get(0).getFirstname());
  }

}
