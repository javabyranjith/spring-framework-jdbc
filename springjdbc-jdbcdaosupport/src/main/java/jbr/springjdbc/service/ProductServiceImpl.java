package jbr.springjdbc.service;

import java.util.List;

import jbr.springjdbc.dao.ProductDao;
import jbr.springjdbc.model.Product;
import jbr.springjdbc.model.ProductCategory;

public class ProductServiceImpl implements ProductService {

  private ProductDao productDao;

  public void setProductDao(ProductDao productDao) {
    this.productDao = productDao;
  }

  @Override
  public void addProduct(Product product) {
    productDao.addProduct(product);
  }

  @Override
  public List<Product> getAllProducts() {
    return productDao.getAllProducts();
  }

  @Override
  public List<Product> getProductsByType(ProductCategory type) {
    return productDao.getProductsByType(type);
  }

}
