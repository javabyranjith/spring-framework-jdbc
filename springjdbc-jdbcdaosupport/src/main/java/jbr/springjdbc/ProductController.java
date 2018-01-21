package jbr.springjdbc;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jbr.springjdbc.dao.ProductDao;
import jbr.springjdbc.model.Product;
import jbr.springjdbc.model.ProductCategory;

public class ProductController {
  public ProductDao productDao;

  public void setProductDao(ProductDao productDao) {
    this.productDao = productDao;
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("jdbcdaosupport-beans.xml");
    ProductController productController = (ProductController) appContext.getBean("productController");

    // productController.addProduct();
    // productController.getAllProducts();
    productController.getProductsByType(ProductCategory.MOBILE);

    appContext.close();
  }

  public void addProduct() {
    Product prod = new Product();
    prod.setId("MOB003");
    prod.setName("Lava");
    prod.setProductCategory(ProductCategory.MOBILE);
    prod.setPrice(65000);
    prod.setQuantity(16);
    productDao.addProduct(prod);

    prod = new Product();
    prod.setId("MOB004");
    prod.setName("Micromax");
    prod.setProductCategory(ProductCategory.MOBILE);
    prod.setPrice(75000);
    prod.setQuantity(10);
    productDao.addProduct(prod);

    prod = new Product();
    prod.setId("LAP002");
    prod.setName("Dell Inspiron");
    prod.setProductCategory(ProductCategory.LAPTOP);
    prod.setPrice(65000);
    prod.setQuantity(8);
    productDao.addProduct(prod);
  }

  public void getAllProducts() {
    List<Product> prods = productDao.getAllProducts();
    for (Product prod : prods) {
      System.out.println("Name: " + prod.getName());
    }
  }

  public void getProductsByType(ProductCategory type) {
    List<Product> prods = productDao.getProductsByType(type);
    for (Product prod : prods) {
      System.out.println("Name: " + prod.getName());
    }
  }

}