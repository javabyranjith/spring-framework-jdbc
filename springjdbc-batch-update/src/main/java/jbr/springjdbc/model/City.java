package jbr.springjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class City {
  private String name;
  private String latitude;
  private String longitude;
  private String country;
  private String state;
  private String population;
}
