package jbr.springjdbc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import jbr.springjdbc.dao.JdbcTemplateDaoImpl;
import jbr.springjdbc.dao.NamedParameterJdbcTemplateDaoImpl;

@Configuration
public class AppConfig {

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
    dataSource.setUsername("root");
    dataSource.setPassword("ranjith");

    return dataSource;
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }

  @Bean
  public JdbcTemplateDaoImpl jdbcTemplateDaoImpl() {
    JdbcTemplateDaoImpl dao = new JdbcTemplateDaoImpl();
    dao.setJdbcTemplate(jdbcTemplate());

    return dao;
  }

  @Bean
  public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
    return new NamedParameterJdbcTemplate(dataSource());
  }

  @Bean
  public NamedParameterJdbcTemplateDaoImpl namedParameterJdbcTemplateDao() {
    NamedParameterJdbcTemplateDaoImpl dao = new NamedParameterJdbcTemplateDaoImpl();
    dao.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate());

    return dao;
  }
}
