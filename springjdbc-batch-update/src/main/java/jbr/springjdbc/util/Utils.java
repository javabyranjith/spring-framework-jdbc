package jbr.springjdbc.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import jbr.springjdbc.model.City;

public class Utils {

  public static List<City> getCityObjList() throws IOException {
    List<City> cities = Files.readAllLines(Paths.get("src/main/resources/city.data")).stream().map(line -> {
      String[] val = line.split("\\|");
      return new City(val[0], val[1], val[2], val[3], val[4], val[5]);
    }).collect(Collectors.toList());
    return cities;
  }

}
