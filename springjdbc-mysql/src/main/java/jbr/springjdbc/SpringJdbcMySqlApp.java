package jbr.springjdbc;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jbr.springjdbc.jdbctemplate.ProductDao;

public class SpringJdbcMySqlApp {

  public static void main(String[] args) throws Exception {
    ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
    ProductDao productDao = (ProductDao) appContext.getBean("productDao");
    productDao.getAllProducts();

    productDao.updateProducts();
    appContext.close();
  }
}
