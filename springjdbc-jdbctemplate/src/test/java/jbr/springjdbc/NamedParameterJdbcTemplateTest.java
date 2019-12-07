package jbr.springjdbc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jbr.springjdbc.config.AppConfig;
import jbr.springjdbc.dao.NamedParameterJdbcTemplateDao;
import jbr.springjdbc.model.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class NamedParameterJdbcTemplateTest {

  @Autowired
  private NamedParameterJdbcTemplateDao namedParameterJdbcTemplate;

  @Test
  public void testAdd() {
    int result = namedParameterJdbcTemplate.addUsingUpdate(new Book(100, "spring framework", "john", 1500));
    System.out.println(result + " row inserted.");
  }

  @Test
  public void testGetById() {
    Book book = namedParameterJdbcTemplate.getByIdUsingQuery(100).get(0);
    System.out.println(book.toString());
    Assert.assertEquals("spring framework", book.getTitle());
    Assert.assertEquals("john", book.getAuthor());
    Assert.assertEquals(1500, book.getPrice());
  }

}
