package jbr.coll.dto;

import java.util.Date;

public class Student {

  private String id, firstname, lastname, email, deptId;
  private Date dob, doj, dol;
  private Integer phone;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDeptId() {
    return deptId;
  }

  public void setDeptId(String deptId) {
    this.deptId = deptId;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public Date getDoj() {
    return doj;
  }

  public void setDoj(Date doj) {
    this.doj = doj;
  }

  public Date getDol() {
    return dol;
  }

  public void setDol(Date dol) {
    this.dol = dol;
  }

  public Integer getPhone() {
    return phone;
  }

  public void setPhone(Integer phone) {
    this.phone = phone;
  }

}
