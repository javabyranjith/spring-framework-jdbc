package jbr.springjdbc.service;

import java.util.List;

import jbr.springjdbc.model.Product;
import jbr.springjdbc.model.ProductCategory;

public interface ProductService {

  void addProduct(Product product);

  List<Product> getAllProducts();

  List<Product> getProductsByType(ProductCategory type);

}
