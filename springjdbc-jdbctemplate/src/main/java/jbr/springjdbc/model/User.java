package jbr.springjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private int id;
  private String name;
  private String address;
  private String email;
  private String phone;
  private String username;
  private String password;
  private String city;
  private String country;

}
