package jbr.springjdbc.dao;

import java.util.List;

import jbr.springjdbc.model.Book;

public interface BookDao {

  void addBook(Book book);

  List<Book> getAllBooks();

  List<Book> getBookById(int id);

}
