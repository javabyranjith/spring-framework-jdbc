package jbr.springjdbc.simplejdbcinsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class StudentDaoImpl implements StudentDao {

  private JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void enrollStudent(Student student) {
    // String query = "INSERT INTO students VALUES (?,?,?,?,?)";

    Map<String, Object> arguments = new HashMap<>();
    arguments.put("name", student.getName());
    arguments.put("dob", student.getDob());
    arguments.put("email", student.getEmail());
    arguments.put("phone", student.getPhone());
    arguments.put("course", student.getCourse());

    SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("students");
    insert.execute(arguments);
  }

  @Override
  public List<Student> getAllStudents() {
    return jdbcTemplate.query("SELECT * FROM students", new BeanPropertyRowMapper<Student>(Student.class));
  }

}
