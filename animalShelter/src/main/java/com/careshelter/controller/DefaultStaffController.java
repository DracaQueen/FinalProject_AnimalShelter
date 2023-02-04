package com.careshelter.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.careshelter.entity.staff;
import com.careshelter.service.AnimalService;
import com.careshelter.service.StaffService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultStaffController implements StaffController {
  
  @Autowired 
  private StaffService staffService;

  @Override
  public List<staff> fetchAllStaff() {

    return staffService.fetchAllStaff();
  }

  @Override
  public staff createStaff(String firstName, String lastName, String certifications,
      String duties) {
    
    return staffService.createStaff(firstName, lastName, certifications, duties);
  }

  @Override
  public void deleteStaff(int deleteStaffId) {
    log.debug("staff={}", deleteStaffId);
    staffService.deleteStaff(deleteStaffId);
    
  }

  @Override
  public staff updateStaff(int staffPK, @Valid staff updatedStaff) {
    // TODO Auto-generated method stub
    return staffService.updateStaff(staffPK, updatedStaff);
  }

}
