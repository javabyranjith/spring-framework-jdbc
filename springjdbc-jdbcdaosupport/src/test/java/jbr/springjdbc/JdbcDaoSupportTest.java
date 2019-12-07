package jbr.springjdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jbr.springjdbc.model.Product;
import jbr.springjdbc.model.ProductCategory;
import jbr.springjdbc.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/jdbcdaosupport-beans.xml" })
@ComponentScan(basePackages = "jbr.springjdbc")
public class JdbcDaoSupportTest {

  @Autowired
  private ProductService productService;

  @Test
  public void testaddProduct() {
    Product prod = new Product();
    prod.setId("MOB003");
    prod.setName("Lava");
    prod.setProductCategory(ProductCategory.MOBILE);
    prod.setPrice(65000);
    prod.setQuantity(16);

    productService.addProduct(prod);
  }

}
