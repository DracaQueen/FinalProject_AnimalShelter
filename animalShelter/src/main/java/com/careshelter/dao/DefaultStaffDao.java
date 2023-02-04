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
import com.careshelter.entity.staff;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultStaffDao implements StaffDao {
  
  @Autowired 
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  public List<staff> fetchAllStaff() {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM staff ";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
          @Override
          public staff mapRow(ResultSet rs, int rowNum) throws SQLException {
         // @formatter:off
            return staff.builder()
                .staffPK(rs.getInt("staff_pk"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .certifications(rs.getString("certifications"))
                .duties(rs.getString("duties"))
                .build();
         // @formatter:on
          }});
  }
  
  public staff createStaff(String firstName, String lastName, String certifications,
      String duties) {      
    SqlParams sqlparams = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    sqlparams.sql = ""
        + "INSERT into staff "
        + "(first_name, last_name, certifications, duties )" 
        + "VALUES (:first_name, :last_name, :certifications, :duties)" ;
    sqlparams.source.addValue("first_name", firstName);
    sqlparams.source.addValue("last_name", lastName);
    sqlparams.source.addValue("certifications", certifications);
    sqlparams.source.addValue("duties", duties);
    

    jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyHolder);
    return staff.builder()
        .staffPK(keyHolder.getKey().intValue())
        .firstName(firstName)
        .lastName(lastName)
        .certifications(certifications)
        .duties(duties)
        .build();
  }

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  
  public staff updateStaff(int staffPK, staff updatedStaff) {
    // @formatter:off
    String sql = ""
        + "UPDATE staff  "
        + "SET "
        + "first_name = :first_name, "
        + "last_name = :last_name, "
        + "certifications = :certifications "
        + "WHERE staff_id = :staff_PK; ";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("first_name", updatedStaff.getFirstName());
    params.put("last_name", updatedStaff.getLastName());
    params.put("certifications", updatedStaff.getCertifications());
    params.put("duties", updatedStaff.getDuties());
    params.put("staff_pk", staffPK);
    
    if (jdbcTemplate.update(sql, params) == 0) {
      throw new NoSuchElementException("update failed!!!! ");
     }
   return staff.builder()
       .staffPK(staffPK)
       .firstName(updatedStaff.getFirstName())
       .lastName(updatedStaff.getLastName())
       .certifications(updatedStaff.getCertifications())
       .duties(updatedStaff.getDuties())
       .build();
   
 }
  public void deleteStaff(int deleteStaffId) {
    // @formatter:off
    String sql = ""
        + "DELETE FROM staff "
        + "WHERE staff_id = :staff_pk;";
    // @formatter:on    
       
    Map<String, Object> params = new HashMap<>();
    
    params.put("staff_pk", deleteStaffId);    
    if (jdbcTemplate.update(sql,  params) == 0) throw new NoSuchElementException();
  }

}
