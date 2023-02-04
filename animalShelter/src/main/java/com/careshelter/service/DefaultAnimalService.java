package com.careshelter.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.careshelter.dao.AnimalDao;
import com.careshelter.entity.animals;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultAnimalService implements AnimalService {
  
  @Autowired
  private AnimalDao animalDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<animals> fetchAllAnimals(animals species) {
 log.info("The fetchAllAnimal method is called with species={}", species);
    
    return animalDao.fetchAllAnimals(species);
  }

  @Override
  public animals createAnimal(String animalPK, String name, String Species, String Breed,
      String Color, String Notes) {
   log.info("The createAnimal method is called with animalPK={}, name={}, Species={}, Breed={}, Color={}, Notes={}",
       animalPK, name, Species, Breed, Color, Notes);
    return animalDao.createAnimal(animalPK, name, Species, Breed, Color, Notes);
  }

  @Override
  public animals updateAnimal(String animalPK, animals updatedAnimal) {
    log.info("Makes updates in animal profile ");
    return animalDao.updateAnimal(animalPK, updatedAnimal);
  }

  @Override
  public void deleteAnimal(String animalPK) {
    log.info("The deleteAnimal method was called with animalePK={}",
        animalPK);
    
   animalDao.deleteAnimal(animalPK);
  }

}
