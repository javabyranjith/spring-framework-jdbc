package jbr.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jbr.springjdbc.model.Book;

@Repository
public class NamedParameterJdbcTemplateDaoImpl implements NamedParameterJdbcTemplateDao {

  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  public int addUsingUpdate(Book book) {
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("id", book.getId());
    paramMap.put("title", book.getTitle());
    paramMap.put("author", book.getAuthor());
    paramMap.put("price", book.getPrice());

    return namedParameterJdbcTemplate.update("INSERT INTO books VALUES(:id,:title,:author,:price)", paramMap);
  }

  public List<Book> getByIdUsingQuery(int id) {
    String query = "SELECT * FROM books WHERE id=:id";
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("id", id);
    List<Book> books = namedParameterJdbcTemplate.query(query, paramMap, new RowMapper<Book>() {

      @Override
      public Book mapRow(ResultSet rs, int arg1) throws SQLException {
        Book b = new Book();
        b.setTitle(rs.getString("title"));
        b.setAuthor(rs.getString("author"));
        b.setPrice(rs.getInt("price"));
        return b;
      }
    });

    return books;
  }

}
