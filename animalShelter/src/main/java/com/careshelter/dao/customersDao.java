package com.careshelter.dao;

import java.util.List;
import com.careshelter.entity.customers;

public interface customersDao {

  static List<customers> fetchAllCustomers() {
    // TODO Auto-generated method stub
    return null;
  }

   static customers createCustomer(String firstName, String lastName) {
    // TODO Auto-generated method stub
    return null;
  }
   
   customers updateCustomer(int customerPK, customers updatedCustomer);  
   
  void deleteCustomer(int deleteCustomerId);

}
