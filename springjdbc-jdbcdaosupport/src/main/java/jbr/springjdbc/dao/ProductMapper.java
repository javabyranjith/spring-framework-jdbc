package jbr.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jbr.springjdbc.model.Product;

public class ProductMapper implements RowMapper<Product> {

  public Product mapRow(ResultSet rs, int arg1) throws SQLException {
    System.out.println("rowmapper call");
    Product prod = new Product();

    prod.setId(rs.getString("id"));
    prod.setName(rs.getString("name"));
    prod.setPrice(rs.getInt("price"));
    prod.setQuantity(rs.getInt("quantity"));

    return prod;
  }

}
