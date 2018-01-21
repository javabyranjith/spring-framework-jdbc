package jbr.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import jbr.springjdbc.model.Product;
import jbr.springjdbc.model.ProductCategory;

public class ProductDaoImpl extends JdbcDaoSupport implements ProductDao {

  @Override
  public void addProduct(Product prod) {
    String query = "INSERT INTO products VALUES (?,?,?,?,?)";

    Object[] params = { prod.getId(), prod.getName(), prod.getProductCategory().name(), prod.getPrice(),
        prod.getQuantity() };
    int[] types = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.LONGVARCHAR, Types.INTEGER };

    getJdbcTemplate().update(query, params, types);
  }

  @Override
  public List<Product> getAllProducts() {
    return getJdbcTemplate().query("SELECT * FROM products", new ProductMapper());
  }

  @Override
  public List<Product> getProductsByType(ProductCategory type) {
    String query = "SELECT * FROM products WHERE category='" + type + "'";

    List<Product> products = getJdbcTemplate().query(query, new ResultSetExtractor<List<Product>>() {

      @Override
      public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
        System.out.println("resultsetextract call");
        List<Product> prods = new ArrayList<>();
        while (rs.next()) {
          Product prod = new Product();
          prod.setId(rs.getString("id"));
          prod.setName(rs.getString("name"));
          prod.setProductCategory(ProductCategory.valueOf(rs.getString("category")));
          prod.setPrice(rs.getInt("price"));
          prod.setQuantity(rs.getInt("quantity"));

          prods.add(prod);
        }
        return prods;
      }
    });

    return products;
  }

}
