package jbr.springjdbc.model;

public class User {

  private String name;
  private String address;
  private String email;
  private String phone;
  private String username;
  private String password;
  private String city;
  private String country;

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Name: " + this.name + "\nAddress: " + this.address + "\nEmail: " + this.email + "\nPhone: " + this.phone
        + "\nUsername: " + this.username + "\nCity: " + this.city + "\nCountry: " + this.country;
  }

}
