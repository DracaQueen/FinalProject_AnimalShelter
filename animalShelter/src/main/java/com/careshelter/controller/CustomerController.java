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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.careshelter.entity.customers;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/customers")
@OpenAPIDefinition(info = @Info(title = "Customer"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface CustomerController {

  // fetch entire list of customers
  @Operation(
      summary = "Returns a list of Customers",
      description = "Returns a list of Customers all first and last name",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of Customers is returned",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = customers.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Customers were found with the input criteria",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.",  
              content = @Content(mediaType = "application/json"))
      }

  )
  @GetMapping("/all")
  @ResponseStatus(code = HttpStatus.OK)
  List<customers> fetchAllCustomers(                                                            
    );
  
  // creates a new customer
  
  @Operation(
      summary = "Creates a new Customer",
      description = "Returns the created Customer",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "A new Customer has been added",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = customers.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Customer were found",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.",  
              content = @Content(mediaType = "application/json")),
      },
      parameters = {
          @Parameter(name = "firstName", 
              allowEmptyValue = false, 
              required = false, 
              description = "The customers first name"),
          @Parameter(name = "lastName", 
          allowEmptyValue = false, 
          required = false, 
          description = "The customers last name"),
          @Parameter(name = "occupation", 
          allowEmptyValue = false, 
          required = false, 
          description = "The customers occupation.")
          }
  )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  customers createCustomer(String firstName, String lastName, String occupation);  
  
  @Operation(
      summary = "updates a Customer",
      description = "Returns the updated Customer",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Returns updated Customer",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = customers.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Customer were found",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.",  
              content = @Content(mediaType = "application/json")),
      }, 
          parameters = {
              @Parameter(name = "customerPK", 
                  allowEmptyValue = false, 
                  required = false, 
                  description = "The Customer's Id within our database")
      }
  )
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  customers updateCustomer(                                                                     
       int customerPK, 
      @Valid @RequestBody customers updatedCustomer); 
  
  @Operation(
      summary = "Deletes an Customer",
      description = "Deletes a Customer by customer_id",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Customer was deleted",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = customers.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Employees were found with the input criteria",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.",  
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "employeePK", 
              allowEmptyValue = false, 
              required = false, 
              description = "employeePK (i.e., 3)"),
      }
  )
      @DeleteMapping("/customerPK")
      @ResponseStatus(code = HttpStatus.OK)
      void deleteCustomer(int deleteCustomerId); 
}
