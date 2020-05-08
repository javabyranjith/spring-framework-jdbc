package jbr.springjdbc.jdbctemplate;

import java.util.List;

import jbr.springjdbc.model.Product;

public interface ProductDao {

  List<Product> getAllProducts() throws Exception;
  
  void updateProducts() throws Exception;
}
