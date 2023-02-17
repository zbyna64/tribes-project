package com.gfa.springadvanced.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

  @Id
  private Long id;
  private String username;
  private String password;

}
