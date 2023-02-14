package com.gfa.springadvanced.models.fromJson;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Generated("jsonschema2pojo")
public class ProductionCompany {

  @SerializedName("id")
  @Expose
  @Id
  private Long id;
//  @SerializedName("logo_path")
//  @Expose
//  private Object logoPath;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("origin_country")
  @Expose
  private String originCountry;
  @ManyToOne
  private Movie movie;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

//  public Object getLogoPath() {
//    return logoPath;
//  }
//
//  public void setLogoPath(Object logoPath) {
//    this.logoPath = logoPath;
//  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOriginCountry() {
    return originCountry;
  }

  public void setOriginCountry(String originCountry) {
    this.originCountry = originCountry;
  }

  @Override
  public String toString() {
    return "ProductionCompany{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", originCountry='" + originCountry + '\'' +
        '}';
  }
}