package jbr.springjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import jbr.springjdbc.dao.CityDao;
import jbr.springjdbc.dao.CityDaoImpl;

@Configuration
@PropertySources({ @PropertySource("classpath:app.properties"), @PropertySource("classpath:log4j.properties") })
public class AppConfig {

  @Autowired
  private Environment env;

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("datasource.classname"));
    dataSource.setUrl(env.getProperty("datasource.url"));
    dataSource.setUsername(env.getProperty("datasource.username"));
    dataSource.setPassword(env.getProperty("datasource.password"));

    return dataSource;
  }

  @Bean
  public CityDao cityDao() {
    return new CityDaoImpl();
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }

}
