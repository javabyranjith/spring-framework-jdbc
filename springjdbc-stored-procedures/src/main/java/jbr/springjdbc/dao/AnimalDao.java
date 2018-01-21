package jbr.springjdbc.dao;

import java.util.List;

import jbr.springjdbc.model.Animal;

public interface AnimalDao {

  void addAnimal(Animal animal);

  List<Animal> getAllAnimals();
}
