package jbr.springjdbc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jbr.springjdbc.config.AppConfig;
import jbr.springjdbc.dao.JdbcTemplateDao;
import jbr.springjdbc.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class JdbcTemplateDaoTest {

  @Autowired
  private JdbcTemplateDao jdbcTemplateDao;

  @Test
  public void addByUpdate() {
    int result = jdbcTemplateDao.addUsingUpdate(new User(300, "ranjith", "chennai, mgr nagar", "ranjith@gmail.com",
        "12345", "chennai", "india", "ranji", "sekar"));
    Assert.assertEquals(1, result);
  }

  @Test
  public void addUsingUpdatePrepStmtSetter() {
    int result = jdbcTemplateDao.addUsingUpdatePrepStmtSetter(
        new User(400, "sekar", "msbadi", "sekar@gmail.com", "98765", "villu", "india", "sekar", "chinna"));
    Assert.assertEquals(1, result);
  }

}
