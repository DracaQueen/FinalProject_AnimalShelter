package com.careshelter.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.careshelter.entity.customers;
import com.careshelter.service.AnimalService;
import com.careshelter.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCustomerController implements CustomerController {
  
  @Autowired 
  private CustomerService customerService;

  @Override
  public List<customers> fetchAllCustomers() {
    
    return customerService.fetchAllCustomers();
  }

  @Override
  public customers createCustomer(String firstName, String lastName, String occupation) {
    
    return customerService.createCustomer(firstName, lastName);
  }

  @Override
  public customers updateCustomer(int customerPK, @Valid customers updatedCustomer) {
    
    return customerService.updateCustomer(customerPK, updatedCustomer);
  }

  @Override
  public void deleteCustomer(int deleteCustomerId) {
    // TODO Auto-generated method stub
    
  }

}
