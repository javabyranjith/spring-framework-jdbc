package jbr.coll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.coll.dao.StudentDao;
import jbr.coll.dto.Student;

public class StudentServiceImpl implements StudentService {

  @Autowired
  public StudentDao studentDao;

  public List<Student> getAllStudents() {
    return studentDao.getAllStudents();
  }

  public Student getStudentById(String id) {
    return studentDao.getStudentById(id);
  }

}
