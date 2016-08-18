package jbr.springjdbc.jdbctemplate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jbr.springdb.jdbctemplate.JdbcTemplateQuery;

public class JdbcTemplateQueryTest {
  JdbcTemplateQuery query;
  ApplicationContext ctx;

  @Before
  public void setUp() throws Exception {
    ctx = new ClassPathXmlApplicationContext("config/jdbc-template-beans.xml");
    query = (JdbcTemplateQuery) ctx.getBean("jdbcTemplateQuery");
  }

  @Test
  public void queryWithBeanPropertyRowMapper() {
    Assert.assertEquals("STU001", query.queryWithBeanPropertyRowMapper().get(1).getUserId());
    Assert.assertEquals("Manoj", query.queryWithBeanPropertyRowMapper().get(1).getFirstname());
  }

  @Test
  public void test() {
    Assert.assertEquals("Ranjith", query.queryPreparedStatementCreator("Ranjith").getFirstname());
  }

}
