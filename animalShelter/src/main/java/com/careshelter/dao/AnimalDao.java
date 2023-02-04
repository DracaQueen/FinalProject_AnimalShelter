package com.careshelter.dao;

import java.util.List;
import com.careshelter.entity.animals;

public interface AnimalDao {

  List<animals> fetchAllAnimals(animals species);
  
  animals createAnimal(String animalPK, String name, String species, String breed, String color, String notes);


  animals updateAnimal(String animalPK, animals updatedAnimal);

  void deleteAnimal(String animalPK);

 

}
