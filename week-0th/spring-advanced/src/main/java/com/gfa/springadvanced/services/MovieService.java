package com.gfa.springadvanced.services;

import com.gfa.springadvanced.models.fromJson.Movie;
import java.util.List;

public interface MovieService {

  Movie getMovie(Long id);

  void save(Movie movie);

  List<Movie> listAllMovies();

}
