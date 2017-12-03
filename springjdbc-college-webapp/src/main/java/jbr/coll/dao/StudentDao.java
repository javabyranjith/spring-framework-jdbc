package jbr.coll.dao;

import java.util.List;

import jbr.coll.dto.Student;

public interface StudentDao {

  List<Student> getAllStudents();

  Student getStudentById(String id);

}
