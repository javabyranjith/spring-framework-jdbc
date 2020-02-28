package jbr.springjdbc;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jbr.springjdbc.dao.CityDao;
import jbr.springjdbc.model.City;
import jbr.springjdbc.util.Utils;

public class App {
  public static void main(String[] args) throws Exception {
    ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
    CityDao cityDao = (CityDao) appContext.getBean("cityDao");
    List<City> cities = Utils.getCityObjList();
    cityDao.flush();
    cityDao.insert(cities);
    cityDao.insertBatch(cities, 1000);
    appContext.close();
  }
}
