package jbr.springjdbc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {

  private int id;
  private String title;
  private String author;
  private int price;

}
