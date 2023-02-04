package com.careshelter.dao;

import java.util.List;
import javax.validation.Valid;
import com.careshelter.entity.staff;

public interface StaffDao {

 static List<staff> fetchAllStaff() {
  // TODO Auto-generated method stub
  return null;
}

  static staff createStaff(String firstName, String lastName, String certifications,
      String duties) {
    // TODO Auto-generated method stub
    return null;
  }
  

  static staff updateStaff(int staffPK, @Valid staff updatedStaff) {
    // TODO Auto-generated method stub
    return null;
  }
  
  
   static void deleteStaff(int deleteStaffId) {
    // TODO Auto-generated method stub
    
  }

}
