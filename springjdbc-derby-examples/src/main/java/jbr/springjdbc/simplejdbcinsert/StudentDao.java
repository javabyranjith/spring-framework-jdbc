package jbr.springjdbc.simplejdbcinsert;

import java.util.List;


public interface StudentDao {

  void enrollStudent(Student user);

  List<Student> getAllStudents();
}
