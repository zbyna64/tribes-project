package com.gfa.springadvanced.models;

import com.google.gson.annotations.SerializedName;

public class MovieManual {

  private Boolean adult;
  private Long budget;
  private Long id;
  @SerializedName("imdb_id")
  private String imdbId;
  @SerializedName("original_title")
  private String title;
  @SerializedName("original_language")
  private String language;


  public Boolean getAdult() {
    return adult;
  }

  public void setAdult(Boolean adult) {
    this.adult = adult;
  }

  public Long getBudget() {
    return budget;
  }

  public void setBudget(Long budget) {
    this.budget = budget;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getImdbId() {
    return imdbId;
  }

  public void setImdbId(String imdbId) {
    this.imdbId = imdbId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  @Override
  public String toString() {
    return "Movie{" +
        "adult=" + adult +
        ", budget=" + budget +
        ", id=" + id +
        ", imdbId='" + imdbId + '\'' +
        ", title='" + title + '\'' +
        ", language='" + language + '\'' +
        '}';
  }
}
