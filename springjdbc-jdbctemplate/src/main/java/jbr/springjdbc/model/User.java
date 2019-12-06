package jbr.springjdbc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

  private String name;
  private String address;
  private String email;
  private String phone;
  private String username;
  private String password;
  private String city;
  private String country;

}
