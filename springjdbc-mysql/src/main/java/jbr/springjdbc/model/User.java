package jbr.springjdbc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

  private String userId;
  private String userType;
  private String firstname;
  private String lastname;
  private String email;
  private String address;
  private Integer phone;

}
