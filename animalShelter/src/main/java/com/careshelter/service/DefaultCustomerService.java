package com.careshelter.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import com.careshelter.dao.customersDao;
import com.careshelter.entity.customers;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DefaultCustomerService implements CustomerService {

  @Override
  public List<customers> fetchAllCustomers() {
    List<customers> customers = customersDao.fetchAllCustomers();
    if(customers.isEmpty()) {
      String msg = String.format("We have no customers");
          throw new NoSuchElementException(msg);
    }
    return customers;
  }

  @Override
  public customers createCustomer(String firstName, String lastName) {
    log.info("create Customers in service layer");
    return customersDao.createCustomer (firstName, lastName);
  }

  @Override
  public customers updateCustomer(int customerPK, customers updatedCustomer) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public customers deleteCustomer(int deleteCustomerId) {
    // TODO Auto-generated method stub
    return null;
  }

}
