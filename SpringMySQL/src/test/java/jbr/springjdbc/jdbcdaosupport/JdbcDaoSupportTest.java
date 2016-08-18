package jbr.springjdbc.jdbcdaosupport;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jbr.springdb.jdbcdaosupport.JdbcDaoSupportDao;

public class JdbcDaoSupportTest {
  ApplicationContext ctx;
  JdbcDaoSupportDao dao;

  @Before
  public void setUp() throws Exception {
    ctx = new ClassPathXmlApplicationContext("config/jdbc-dao-support-beans.xml");
    dao = (JdbcDaoSupportDao) ctx.getBean("jdbcDaoSupportDao");
  }

  @Test
  public void testJdbcDaoSupport() {
    Assert.assertEquals("Sachin", dao.getUsers().get(2).getFirstname());
    Assert.assertEquals("sachin@gmail.com", dao.getUsers().get(2).getEmail());
  }

}
