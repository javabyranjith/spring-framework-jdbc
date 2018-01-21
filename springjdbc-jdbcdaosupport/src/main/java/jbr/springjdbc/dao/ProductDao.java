package jbr.springjdbc.dao;

import java.util.List;

import jbr.springjdbc.model.Product;
import jbr.springjdbc.model.ProductCategory;

public interface ProductDao {

  void addProduct(Product product);

  List<Product> getAllProducts();

  List<Product> getProductsByType(ProductCategory type);
}
