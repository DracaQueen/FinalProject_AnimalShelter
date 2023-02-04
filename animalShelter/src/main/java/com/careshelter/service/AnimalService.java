package com.careshelter.service;

import java.util.List;
import com.careshelter.entity.animals;

public interface AnimalService {
  
  List<animals> fetchAllAnimals(animals species);
  
  animals createAnimal(String animalPK, String name, String Species, String Breed,
      String Color, String Notes);
  
 animals updateAnimal(String animalPK, animals updatedAnimal);
  
  void deleteAnimal(String animalPK);

}
