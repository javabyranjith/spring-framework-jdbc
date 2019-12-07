package jbr.springjdbc.dao;

import java.util.List;

import jbr.springjdbc.model.Book;

public interface NamedParameterJdbcTemplateDao {
  int addUsingUpdate(Book book);

  List<Book> getByIdUsingQuery(int id);
}
