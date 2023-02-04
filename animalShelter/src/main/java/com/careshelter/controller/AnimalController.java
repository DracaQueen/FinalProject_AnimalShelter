package com.careshelter.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.careshelter.entity.animals;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/animals")
@OpenAPIDefinition(info = @Info(title = "database of animals"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface AnimalController {
 
  // (GET) returns a list of animals by species
  @Operation(
      summary = "Returns a list of All Animals",
      description = "Returns a list of all animals in database",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of Animals is returned",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = animals.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Animals were found with the input criteria",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.",  
              content = @Content(mediaType = "application/json"))
      }

  )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<animals> fetchAllAnimals(
      @RequestParam(required = false)
      animals species);
  
 
  //(POST) Create a profile for new animal
  @Operation(
      summary = "Record a new animal",
      description = "Create profile for new animal by Id, Name, Species, Breed, Color, and Notes",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "Profile is created!", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = animals.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to set up profile with current input criteria.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "AnimalId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The assigned Id of the animal"),
          @Parameter(
              name = "name",
              allowEmptyValue = false,
              required = false,
              description = "The Animal's name"),
          @Parameter(
              name = "species",
              allowEmptyValue = false,
              required = false,
              description = "Species of animal"),
          @Parameter(
              name = "breed",
              allowEmptyValue = false,
              required = false,
              description = "Breed of animal"),
          @Parameter(
              name = "color",
              allowEmptyValue = false,
              required = false,
              description = "Animal's fur color"),
          @Parameter(
              name = "notes",
              allowEmptyValue = false,
              required = false,
              description = "Anything to note about the animal")
      }
  )
  
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  animals createAnimal(
     @RequestParam(required = false) 
     String animalPK,
     @RequestParam(required = false)
     String name,
     @RequestParam(required = false)
     String Species,
     @RequestParam(required = false)
     String Breed,
     @RequestParam(required = false)
     String Color,
     @RequestParam(required = false)
     String Notes);  

//(PUT) Updates changes on any animal living in the shelter
  @Operation(
      summary = "Updates on a Animal",
      description = "Update information on a current animal",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "Profile is updated!", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = animals.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to update profile with the input criteria.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json"))
      },
          parameters = {
              @Parameter(
                  name = "AnimalId", 
                  allowEmptyValue = false, 
                  required = false, 
                  description = "The assigned Id of the animal")
            
      }
  )
  
 
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
 animals updateAnimal(  
     String animalPK, 
     @Valid @RequestBody animals updatedAnimal);
  
  //(DELETE) If an animal passes away while at the shelter 
 @Operation(
     summary = "Deletes a animal",
     description = "Delete an animal profile if they pass away in the shelter",
     responses = {
         @ApiResponse(
             responseCode = "200", 
             description = "Animal is deleted.", 
             content = @Content(
                 mediaType = "application/json", 
             schema = @Schema(implementation = animals.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid.", 
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "No animals were found with the input criteria.", 
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "An unplanned error occurred.", 
             content = @Content(
                 mediaType = "application/json"))
     },
     parameters = {
         @Parameter(
             name = "animalId", 
             allowEmptyValue = false, 
             required = false, 
             description = "Animal's ID number") 
     }
 )
  
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  void deleteAnimal(
      @RequestParam(required = false) 
      String animalPK);
  

}
