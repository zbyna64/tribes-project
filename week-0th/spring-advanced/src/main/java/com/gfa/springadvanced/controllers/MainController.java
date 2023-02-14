package com.gfa.springadvanced.controllers;

import com.gfa.springadvanced.models.MovieManual;
import com.gfa.springadvanced.models.fromJson.Movie;
import com.gfa.springadvanced.services.MovieService;
import com.gfa.springadvanced.services.MovieServiceAPI;
import com.gfa.springadvanced.services.MovieServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RestController
public class MainController {

  private final MovieService movieService;

  @Autowired
  public MainController(MovieService movieService) {
    this.movieService = movieService;
  }


  @GetMapping("/{id}")
  public Movie getPost(@PathVariable("id") Long id) {
    return movieService.getMovie(id);
  }

  @GetMapping("/list")
  public List<Movie> list() {
    return movieService.listAllMovies();
  }

}
