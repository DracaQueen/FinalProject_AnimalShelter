package com.careshelter.service;

import java.util.List;
import com.careshelter.entity.customers;

public interface CustomerService {

 List<customers> fetchAllCustomers();                                                                                          

  customers createCustomer(String firstName, String lastName);                    
  
  customers updateCustomer(int customerPK, customers updatedCustomer);  
  
  customers deleteCustomer(int deleteCustomerId);
}
