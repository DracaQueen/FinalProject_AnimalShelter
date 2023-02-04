package com.careshelter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class animals {
  private String animalPK;
  private String name;
  private String species;
  private String breed;
  private String color;
  private String history;
  private String health;
  private int activityLevel;
  private String diet;
  private int grooming;
  private Status adoptionStatus;
  private SocialWithAnimals Social;
  private GoodWithKids goodWithKids;
  private String likes;
  private String dislikes;
  private String notes;

}
