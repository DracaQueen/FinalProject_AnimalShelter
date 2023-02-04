package com.careshelter.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class customers {
  private Long customerPK;
  private String firstName;
  private String lastName;

}
