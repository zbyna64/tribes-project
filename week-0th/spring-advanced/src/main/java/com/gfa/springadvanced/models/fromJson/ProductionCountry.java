package com.gfa.springadvanced.models.fromJson;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Generated("jsonschema2pojo")
public class ProductionCountry {

  @SerializedName("iso_3166_1")
  @Expose
  private String iso31661;
  @SerializedName("name")
  @Expose
  @Id
  @Column(length = 40)
  private String name;
  @ManyToOne
  private Movie movie;

  public String getIso31661() {
    return iso31661;
  }

  public void setIso31661(String iso31661) {
    this.iso31661 = iso31661;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "ProductionCountry{" +
        "iso31661='" + iso31661 + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
