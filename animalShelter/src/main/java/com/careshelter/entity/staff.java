package com.careshelter.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class staff {
  private int staffPK;
  private String firstName;
  private String lastName;
  private String certifications;
  private String duties;

}
