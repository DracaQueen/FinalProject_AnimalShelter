package com.careshelter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import com.careshelter.entity.customers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

@Component
@Slf4j
public class DefaultCustomersDao implements customersDao{
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  public List<customers> fetchAllCustomers() {                                                  
    log.info("In customer.dao.fetchAllCustomers");
    
 // @formatter:off
    String sql = ""
        +"SELECT * "
        + "FROM customers; ";
    // @formatter:on  
    
    Map<String, Object> params = new HashMap<>();
    return jdbcTemplate.query(sql,
        new RowMapper<customers>() {
          @Override
          public customers mapRow(ResultSet rs, int rowNum) throws SQLException {
            // @formatter:off
            return customers.builder()
                .customerPK(rs.getLong("customer_pk"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .build();
            // @formatter:on
          }});
  }
  
  public class CustomerResultSetExtractor implements ResultSetExtractor<customers> {
    @Override
    public customers extractData(ResultSet rs) 
        throws SQLException, DataAccessException {
      rs.next();
      // @formatter:off
      return customers.builder()
          .customerPK(rs.getLong("customer_pk"))
          .firstName(rs.getString("first_name"))
          .lastName(rs.getString("last_name"))
          .build();
      // @formatter:on
    }
  }


  public customers createCustomer(String firstName, String lastName) {
    SqlParams sqlparams = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    sqlparams.sql = ""
        + "INSERT into customer "
        + "(first_name, last_name)" 
        + "VALUES (:first_name, :last_name)" ;
    sqlparams.source.addValue("first_name", firstName);
    sqlparams.source.addValue("last_name", lastName);
    

    jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyHolder);
    return customers.builder()
        .customerPK(keyHolder.getKey().longValue())
        .firstName(firstName)
        .lastName(lastName)
        .build();
  }

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  
  public customers updateCustomer(int customerPK, customers updatedCustomer) {                   
    // @formatter:off
    String sql = ""
        + "UPDATE customer "
        + "SET "
        + "first_name = :first_name, "
        + "last_name = :last_name, "
        + "WHERE customer_pk = :customer_pk; ";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("first_name", updatedCustomer.getFirstName());
    params.put("last_name", updatedCustomer.getLastName());
    params.put("customer_pk", customerPK);
    
  
      if (jdbcTemplate.update(sql, params) == 0) {
       throw new NoSuchElementException("update failed :( ");
      }
    return customers.builder()
        .customerPK((long) customerPK)
        .firstName(updatedCustomer.getFirstName())
        .lastName(updatedCustomer.getLastName())
        .build();
    
  }

  @Override
  public void deleteCustomer(int deleteCustomerId) {
    String sql = ""
        + "DELETE FROM customers "
        + "WHERE customer_pk = :customer_pk;";
    // @formatter:on    
       
    Map<String, Object> params = new HashMap<>();
    
    params.put("customer_pk", deleteCustomerId);    
    if (jdbcTemplate.update(sql,  params) == 0) throw new NoSuchElementException();
  } 
}
