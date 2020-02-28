package jbr.springjdbc.dao;

import java.util.List;

import jbr.springjdbc.model.City;

public interface CityDao {

  void flush();

  void add(List<City> cities);

  int insert(List<City> cities);

  int insertBatch(List<City> cities, int batchSize);

  int update(List<City> cities);

  int[][] updateBatch(List<City> cities, int batchSize);
}
