package jbr.springjdbc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import jbr.springjdbc.model.City;

@Repository
public class CityDaoImpl implements CityDao {
  private static final Logger log = Logger.getLogger(CityDaoImpl.class);

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public int insert(List<City> cities) {
    log.info("insert - started");
    long start = System.currentTimeMillis();
    String sql = "INSERT INTO city VALUES (?,?,?,?,?,?)";

    int[] result = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setString(1, cities.get(i).getName());
        ps.setString(2, cities.get(i).getLatitude());
        ps.setString(3, cities.get(i).getLongitude());
        ps.setString(4, cities.get(i).getCountry());
        ps.setString(5, cities.get(i).getState());
        ps.setString(6, cities.get(i).getPopulation());
      }

      @Override
      public int getBatchSize() {
        return cities.size();
      }
    });
    log.info(result.length + " insert - Execution time: " + (System.currentTimeMillis() - start) + " ms");
    log.info("insert - completed");
    return result.length;
  }

  @Override
  public int insertBatch(List<City> cities, int batchSize) {
    log.info("insertBatch - started");
    long start = System.currentTimeMillis();
    String sql = "INSERT INTO city VALUES (?,?,?,?,?,?)";

    int[][] count = jdbcTemplate.batchUpdate(sql, cities, batchSize, new ParameterizedPreparedStatementSetter<City>() {
      @Override
      public void setValues(PreparedStatement ps, City city) throws SQLException {
        ps.setString(1, city.getName());
        ps.setString(2, city.getLatitude());
        ps.setString(3, city.getLongitude());
        ps.setString(4, city.getCountry());
        ps.setString(5, city.getState());
        ps.setString(6, city.getPopulation());
      }
    });
    log.info(count.length + " insertBatch - Execution time: " + (System.currentTimeMillis() - start) + " ms");
    log.info("insertBatch - completed.");
    return count.length;
  }

  @Override
  public int update(List<City> cities) {
    return 0;
  }

  @Override
  public int[][] updateBatch(List<City> cities, int batchSize) {
    return null;
  }

  @Override
  public void add(List<City> cities) {
    long start = System.currentTimeMillis();
    String sql = "INSERT INTO city VALUES (?,?,?,?,?,?)";

    cities.forEach(city -> jdbcTemplate.update(sql, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, city.getName());
        ps.setString(2, city.getLatitude());
        ps.setString(3, city.getLongitude());
        ps.setString(4, city.getCountry());
        ps.setString(5, city.getState());
        ps.setString(6, city.getPopulation());
      }
    }));
    log.info("Execution time: " + (System.currentTimeMillis() - start) + " ms");
  }

  @Override
  public void flush() {
    log.info("flush - started");
    jdbcTemplate.execute("delete from city");
    log.info("flush - completed");
  }
}
