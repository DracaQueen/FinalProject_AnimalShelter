package com.careshelter.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.careshelter.entity.animals;
import com.careshelter.service.AnimalService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultAnimalController implements AnimalController {
  
  @Autowired 
  private AnimalService animalService;

  @Override
  public List<animals> fetchAllAnimals(animals species) {
    log.debug("species={}", species);
    return animalService.fetchAllAnimals(species);
  }

  @Override
  public animals createAnimal(String animalPK, String name, String Species, String Breed,
      String Color, String Notes) {
    
    return animalService.createAnimal(animalPK, name, Species, Breed, Color, Notes);
  }

  @Override
  public animals updateAnimal(String animalPK, 
      @Valid animals updatedAnimal) {
    
    return animalService.updateAnimal(animalPK, updatedAnimal);
  }

  @Override
  public void deleteAnimal(String animalPK) {
    log.debug("animalPK={}", animalPK);
    animalService.deleteAnimal(animalPK);
  }


}
