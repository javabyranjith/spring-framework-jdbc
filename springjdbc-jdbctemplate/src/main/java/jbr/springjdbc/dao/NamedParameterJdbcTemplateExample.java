package jbr.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import jbr.springjdbc.model.Book;

public class NamedParameterJdbcTemplateExample {

  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public void setDataSource(DataSource dataSource) {
    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

  public void addBook(Book book) {
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("id", book.getId());
    paramMap.put("title", book.getTitle());
    paramMap.put("author", book.getAuthor());
    paramMap.put("price", book.getPrice());

    namedParameterJdbcTemplate.update("INSERT INTO books VALUES(:id,:title,:author,:price)", paramMap);
  }

  public List<Book> getAllBooks() {
    return null;
  }

  public List<Book> getBookById(int id) {
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
