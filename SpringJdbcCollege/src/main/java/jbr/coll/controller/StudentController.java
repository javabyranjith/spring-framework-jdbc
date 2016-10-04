package jbr.coll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.coll.dto.Student;
import jbr.coll.service.StudentService;

public class StudentController {

  @Autowired
  public StudentService studentService;

  public List<Student> getAllStudents() {
    return studentService.getAllStudents();
  }

  public Student getStudentById(String id) {
    return studentService.getStudentById(id);
  }
}
