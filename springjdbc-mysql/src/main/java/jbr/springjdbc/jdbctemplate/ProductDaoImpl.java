package jbr.springjdbc.jdbctemplate;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jbr.springjdbc.model.Product;
import jbr.springjdbc.util.SpringJdbcUtil;

@Repository
public class ProductDaoImpl implements ProductDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Product> getAllProducts() throws Exception {
    List<String> ids = Files.readAllLines(Paths.get("product-id.data"));

    String sql = "SELECT * FROM product WHERE (1,id) IN %s";
    String selectQuery = String.format(sql, SpringJdbcUtil.buildInClause(ids, false, "1"));

    List<Product> products = jdbcTemplate.query(selectQuery, new BeanPropertyRowMapper<Product>(Product.class));
    System.out.println(products.size());
    return null;
  }

  @Override
  public void updateProducts() {

  }

}
