package jbr.springjdbc.jdbctemplate;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jbr.springjdbc.model.Product;
import jbr.springjdbc.util.SpringJdbcUtil;

@Repository
public class ProductDaoImpl implements ProductDao {
  private static final Logger log = Logger.getLogger(ProductDaoImpl.class);

  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  @Override
  public List<Product> getAllProducts() throws Exception {
    List<String> ids = Files.readAllLines(Paths.get("src/main/resources/product-id.data"));

    String sql = "SELECT * FROM product WHERE (1,id) IN %s";
    String selectQuery = String.format(sql, SpringJdbcUtil.buildInClause(ids, true, "1"));

    List<Product> products = jdbcTemplate.query(selectQuery, new BeanPropertyRowMapper<Product>(Product.class));
    log.info("selected count: " +products.size());
    return null;
  }

  @Override
  public void updateProducts() throws Exception {
    List<String> ids = Files.readAllLines(Paths.get("src/main/resources/product-id.data"));
    String sql = "UPDATE product SET category='new' WHERE (1,id) IN %s";
    String updateQuery = String.format(sql, SpringJdbcUtil.buildInClause(ids, true, "1"));
    int count = jdbcTemplate.update(updateQuery);
    log.info("update count: " + count);

    // check
    String sql1 = "SELECT count(*) FROM product where category='new'";
    String result = jdbcTemplate.queryForObject(sql1, String.class);
    log.info("count: " + result);
  }

}
