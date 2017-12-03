package jbr.coll;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jbr.coll.controller.StudentController;
import jbr.coll.dto.Student;

//@ContextConfiguration(locations = { "classPath*:jbr-college-config.xml" })
//@RunWith(SpringJUnit4ClassRunner.class)
public class StudentTest {

  ApplicationContext appContext;
  StudentController studentController;

  @Before
  public void init() throws Exception {
    appContext = new ClassPathXmlApplicationContext("jbr-college-config.xml");
    studentController = (StudentController) appContext.getBean("studentController");
  }

  @Test
  public void test() {
    List<Student> students = studentController.getAllStudents();
    System.out.println(students.size());
  }

}
