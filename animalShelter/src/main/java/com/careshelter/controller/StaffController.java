package com.careshelter.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.careshelter.entity.staff;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/staff")
@OpenAPIDefinition(info = @Info(title = "Staff"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface StaffController {
  @Operation(
      summary = "Returns all Staff",
      description = "Returns a List of Staff members",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A List of all Staff is returned",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = staff.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Staff members were found with the input criteria",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.",  
              content = @Content(mediaType = "application/json"))
      }
  )
  
        @GetMapping("/staff")
        @ResponseStatus(code = HttpStatus.OK)
        List<staff> fetchAllStaff(); 
        
        @Operation(
            summary = "Returns a new Staff member",
            description = "Returns a staff member given a first and last name",
            responses = {
                @ApiResponse(
                    responseCode = "201", 
                    description = "A new Staff member has been created",
                    content = @Content(
                        mediaType = "application/json", 
                        schema = @Schema(implementation = staff.class))),
                @ApiResponse(
                    responseCode = "400", 
                    description = "The request parameters are invalid",  
                    content = @Content(mediaType = "application/json")),
                @ApiResponse(
                    responseCode = "404", 
                    description = "No Staff component was not found with the input criteria",  
                    content = @Content(mediaType = "application/json")),
                @ApiResponse(
                    responseCode = "500", 
                    description = "An unplanned error occurred.",  
                    content = @Content(mediaType = "application/json"))
            },
            parameters = {
                @Parameter(name = "StaffId", 
                    allowEmptyValue = false, 
                    required = false, 
                    description = "Staff member's ID number"),
                @Parameter(name = "firstName", 
                allowEmptyValue = false, 
                required = false, 
                description = "First name (i.e., 'John')"),
                @Parameter(name = "lastName", 
                allowEmptyValue = false, 
                required = false, 
                description = "Last name (i.e., 'Doe')"),
                @Parameter(name = "certifications", 
                allowEmptyValue = false, 
                required = false, 
                description = "What they are qualified for"),
                @Parameter(name = "duties", 
                allowEmptyValue = false, 
                required = false, 
                description = "Tasks they are responsible for")
            }
            
        )
        
         @PostMapping
         @ResponseStatus(code = HttpStatus.CREATED)
         staff createStaff(String firstName, String lastName,String certifications,
         String duties);
        
        @Operation(
            summary = "updates a Staff Member",
            description = "Returns the updated Staff Member",
            responses = {
                @ApiResponse(
                    responseCode = "200",
                    description = "Returns updated Staff",
                    content = @Content(
                        mediaType = "application/json", 
                        schema = @Schema(implementation = staff.class))),
                @ApiResponse(
                    responseCode = "400", 
                    description = "The request parameters are invalid",  
                    content = @Content(mediaType = "application/json")),
                @ApiResponse(
                    responseCode = "404", 
                    description = "No Staff were found",  
                    content = @Content(mediaType = "application/json")),
                @ApiResponse(
                    responseCode = "500", 
                    description = "An unplanned error occurred.",  
                    content = @Content(mediaType = "application/json")),
            }, 
                parameters = {
                    @Parameter(name = "staffPK", 
                        allowEmptyValue = false, 
                        required = false, 
                        description = "The Staff Member's Id within our database")
            }
        )
        @PutMapping
        @ResponseStatus(code = HttpStatus.OK)
        staff updateStaff(                                                                     
             int staffPK, 
            @Valid @RequestBody staff updatedStaff); 
 
        @Operation(
            summary = "Deletes a Staff member",
            description = "Deletes a Staff member given an id",
            responses = {
                @ApiResponse(
                    responseCode = "200",
                    description = "Staff member was deleted",
                    content = @Content(
                        mediaType = "application/json", 
                        schema = @Schema(implementation = staff.class))),
                @ApiResponse(
                    responseCode = "400", 
                    description = "The request parameters are invalid",  
                    content = @Content(mediaType = "application/json")),
                @ApiResponse(
                    responseCode = "404", 
                    description = "No Staff members were found with the input criteria",  
                    content = @Content(mediaType = "application/json")),
                @ApiResponse(
                    responseCode = "500", 
                    description = "An unplanned error occurred.",  
                    content = @Content(mediaType = "application/json"))
            },
            parameters = {
                @Parameter(name = "staffPK", 
                    allowEmptyValue = false, 
                    required = false, 
                    description = "staffPK (i.e., 3)"),
            }
        )
            @DeleteMapping("/staffPK")
            @ResponseStatus(code = HttpStatus.OK)
            void deleteStaff(int deleteStaffId); 
                
}
