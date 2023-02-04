package com.careshelter.service;

import java.util.List;
import java.util.NoSuchElementException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.careshelter.dao.StaffDao;
import com.careshelter.entity.staff;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultStaffService implements StaffService {

  @Autowired
  private StaffDao staffDao;
  
  @Override
  public List<staff> fetchAllStaff() {
    List<staff> staff = StaffDao.fetchAllStaff();
    if(staff.isEmpty()) {
      String msg = String.format("We have no staff :(");
          throw new NoSuchElementException(msg);
    }
  
    return staff;
  }

  @Override
  public staff createStaff(String firstName, String lastName, String certifications,
      String duties) {
    log.info("create Staff in service layer");
    return StaffDao.createStaff (firstName, lastName, certifications, duties);
  }

  @Override
  public staff updateStaff(int staffPK, @Valid staff updatedStaff) {
    log.info("updates Customer in service layer");
    return StaffDao.updateStaff(staffPK, updatedStaff);
  }
  @Override
  public void deleteStaff(int deleteStaffId) {
    log.info("The deleteStaff method was called with staffPK={}",
        deleteStaffId);
    
   StaffDao.deleteStaff(deleteStaffId);
  }

}
