package jbr.coll.service;

import java.util.List;

import jbr.coll.dto.Student;

public interface StudentService {

  List<Student> getAllStudents();

  Student getStudentById(String id);

}
