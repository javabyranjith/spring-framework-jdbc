package jbr.springjdbc.simplejdbcinsert;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentController {
  private StudentDao studentDao;

  public void setStudentDao(StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("simplejdbcinsert-beans.xml");
    StudentController studentController = (StudentController) appContext.getBean("studentController");

    //studentController.enrollStudent();
    studentController.getAllStudents();

    appContext.close();
  }

  public void enrollStudent() {
    Student stud = new Student();
    stud.setName("Anbu");
    stud.setDob("12-May-1998");
    stud.setEmail("anbu@gmail.com");
    stud.setPhone(98997733);
    stud.setCourse("B.Tech");

    studentDao.enrollStudent(stud);
  }

  public void getAllStudents() {
    List<Student> students = studentDao.getAllStudents();
    for (Student student : students) {
      System.out.println("Name: " + student.getName());
    }
  }

}
