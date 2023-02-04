package com.careshelter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.careshelter.entity.GoodWithKids;
import com.careshelter.entity.SocialWithAnimals;
import com.careshelter.entity.Status;
import com.careshelter.entity.animals;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultAnimalDao implements AnimalDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<animals> fetchAllAnimals(animals species) {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM animals "
        + "WHERE species = :species ";
    
    
    Map<String, Object> params = new HashMap<>();
    params.put("species", species);
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {
          @Override
          public animals mapRow(ResultSet rs, int rowNum) throws SQLException {
            // @formatter:off
            return animals.builder()
                .animalPK(rs.getString("animal_id"))
                .name(rs.getString("name"))
                .species(rs.getString("species"))
                .breed(rs.getString("breed"))
                .color(rs.getString("color"))
                .history(rs.getString("history"))
                .health(rs.getString("health"))
                .activityLevel(rs.getInt("activityLevel"))
                .diet(rs.getString("diet"))
                .grooming(rs.getInt("grooming"))
                .adoptionStatus(Status.valueOf(rs.getString("status")))
                .Social(SocialWithAnimals.valueOf(rs.getString("getsAlongWithOtherAnimals")))
                .goodWithKids(GoodWithKids.valueOf(rs.getString("goodWithKids")))
                .likes(rs.getString("likes"))
                .dislikes(rs.getString("dislikes"))
                .notes(rs.getString("notes"))
                .build();
            // @formatter:on
          }
    });    
  }

  @Override
  public animals createAnimal(String animalPK, String name, String species, String breed,
      String color, String notes) {
    SqlParams sqlparams = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    sqlparams.sql = ""
        + "INSERT into animals "
        + "(animal_id, name, species, breed, color, notes) " 
        + "VALUES (:animal_id, :name, :species, :breed, :color, :notes)" ;
    sqlparams.source.addValue("animal_id", animalPK);
    sqlparams.source.addValue("name", name);
    sqlparams.source.addValue("speceis", species);
    sqlparams.source.addValue("breed", breed);
    sqlparams.source.addValue("color", color);
    sqlparams.source.addValue("notes", notes);

    jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyHolder);
    return animals.builder()
        .animalPK(keyHolder.getKey().toString())
        .name(name)
        .species(species)
        .breed(breed)
        .color(color)
        .notes(notes)
        .build();
  }

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  

  @Override
  public animals updateAnimal(String animalPK, animals updatedAnimal) {
 // @formatter:off
    String sql = ""
        + "UPDATE animals "
        + "SET"
        + "name = :name, "
        + "species = :species, "
        + "breed = :breed, "
        + "color = :color, "
        + "grooming = :grooming, "
        + "activityLevel = :activityLevel, "
        + "goodWithKids = :goodWithKids, "
        + "status = :status, "
        + "socialWithAnimals = :socialWithAnimals, "
        + "diet = :diet, "
        + "history = :history, "
        + "health = :health, "
        + "likes = :likes, "
        + "dislikes = :dislikes, "
        + "notes = :notes "
        + "WHERE animal_id = :animal_id;";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("name", updatedAnimal.getName());
    params.put("species", updatedAnimal.getSpecies());
    params.put("breed", updatedAnimal.getBreed());
    params.put("color", updatedAnimal.getColor());
    params.put("grooming",updatedAnimal.getGrooming() );
    params.put("activityLevel", updatedAnimal.getActivityLevel());
    params.put("goodWithKids", updatedAnimal.getGoodWithKids());
    params.put("status", updatedAnimal.getAdoptionStatus());
    params.put("socialWithAnimals", updatedAnimal.getSocial());
    params.put("diet", updatedAnimal.getDiet());
    params.put("history", updatedAnimal.getHistory());
    params.put("health", updatedAnimal.getHealth());
    params.put("likes", updatedAnimal.getLikes());
    params.put("dislikes", updatedAnimal.getDislikes());
    params.put("notes", updatedAnimal.getNotes());
    params.put("animal_id", animalPK);
    
   
      if (jdbcTemplate.update(sql, params) == 0) {
      throw new NoSuchElementException("update failed!!!! ");
     }
    return animals.builder()
        .animalPK(animalPK)
        .name(updatedAnimal.getName())
        .species(updatedAnimal.getSpecies())
        .breed(updatedAnimal.getBreed())
        .color(updatedAnimal.getColor())
        .grooming(updatedAnimal.getGrooming())
        .activityLevel(updatedAnimal.getActivityLevel())
        .goodWithKids(updatedAnimal.getGoodWithKids())
        .adoptionStatus(updatedAnimal.getAdoptionStatus())
        .Social(updatedAnimal.getSocial())
        .diet(updatedAnimal.getDiet())
        .history(updatedAnimal.getHistory())
        .health(updatedAnimal.getHealth())
        .likes(updatedAnimal.getLikes())
        .dislikes(updatedAnimal.getDislikes())
        .notes(updatedAnimal.getNotes())
        .build();
    
  }

  @Override
  public void deleteAnimal(String animalPK) {
    // @formatter:off
    String sql = ""
        + "DELETE FROM animals "
        + "WHERE animal_id = :animal_id;";
    // @formatter:on    
       
    Map<String, Object> params = new HashMap<>();
    
    params.put("animal_id", animalPK);    
    if (jdbcTemplate.update(sql,  params) == 0) throw new NoSuchElementException();
  }
}
