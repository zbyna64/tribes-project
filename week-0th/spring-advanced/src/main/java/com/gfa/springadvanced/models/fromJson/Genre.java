package com.gfa.springadvanced.models.fromJson;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Generated("jsonschema2pojo")
public class Genre {

  @SerializedName("id")
  @Expose
  @Id
  private Long id;
  @SerializedName("name")
  @Expose
  private String name;
  @ManyToOne
  private Movie movie;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Genre{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
