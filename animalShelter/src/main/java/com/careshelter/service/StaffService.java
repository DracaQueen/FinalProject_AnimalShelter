package com.careshelter.service;

import java.util.List;
import javax.validation.Valid;
import com.careshelter.entity.staff;

public interface StaffService {
  List<staff> fetchAllStaff();
  
  staff createStaff(String firstName, String lastName, String certifications,
      String duties);
  
  staff updateStaff(int staffPK, @Valid staff updatedStaff);
  
  void deleteStaff(int deleteStaffId);
}
