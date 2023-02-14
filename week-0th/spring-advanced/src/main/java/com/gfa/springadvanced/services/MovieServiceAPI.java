package com.gfa.springadvanced.services;

import com.gfa.springadvanced.models.fromJson.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieServiceAPI {

  //for query parameter
//  @GET("movie/{id}")
//  Call<Movie> getMovie(@Path("id") Long id, @Query("api_key") String key);

  //for @Header annotation
//  @GET("movie/{id}")
//  Call<Movie> getMovie(@Path("id") Long id, @Header("Authorization") String auth);

  //for intercept
  @GET("movie/{id}")
  Call<Movie> getMovie(@Path("id") Long id);

}
