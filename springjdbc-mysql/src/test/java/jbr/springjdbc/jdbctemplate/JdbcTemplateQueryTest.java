package jbr.springjdbc.jdbctemplate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jbr.springdb.jdbctemplate.JdbcTemplateQuery;
import jbr.springdb.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/jdbc-template-beans.xml" })
public class JdbcTemplateQueryTest {

  @Autowired
  private JdbcTemplateQuery query;

  @Test
  public void queryWithBeanPropertyRowMapper() {
    User user1=query.queryWithBeanPropertyRowMapper().get(1);
    System.out.println(user1.toString());
    Assert.assertEquals("STU001", user1.getUserId());
    Assert.assertEquals("Manoj", user1.getFirstname());
  }

  @Test
  public void testPreparedStmtCreator() {
    Assert.assertEquals("Ranjith", query.queryPreparedStatementCreator("Ranjith").getFirstname());
  }

}
