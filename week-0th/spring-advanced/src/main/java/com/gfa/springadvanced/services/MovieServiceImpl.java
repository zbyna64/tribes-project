package com.gfa.springadvanced.services;


import com.gfa.springadvanced.models.MovieManual;
import com.gfa.springadvanced.models.fromJson.Movie;
import com.gfa.springadvanced.repositories.MovieRepository;
import com.gfa.springadvanced.utils.RetrofitInitializer;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@Service
public class MovieServiceImpl implements MovieService {

  private Retrofit retrofit;
  private MovieServiceAPI movieServiceAPI;
  private final MovieRepository movieRepository;

//  public String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYjNkNTBmNWQ3NjMyNmNhYzUyMTUyYTExYjU5YTM1YSIsInN1YiI6IjYzZWI1NDc5OGU4NzAyMDA4MjNhYTQ3ZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.TN7UYjD7zuhUTopLqScQbemQzYTjMoMikNTazro8HLo";

  @Autowired
  public MovieServiceImpl(MovieRepository movieRepository) {
    this.retrofit = RetrofitInitializer.getRetrofit();
    this.movieServiceAPI = retrofit.create(MovieServiceAPI.class);
    this.movieRepository = movieRepository;
  }


  @Override
  public List<Movie> listAllMovies() {
    return movieRepository.findAll();
  }

  @Override
  public Movie getMovie(Long id) {

//    Call<Movie> callMovie = movieServiceAPI.getMovie(id, token);
    Call<Movie> callMovie = movieServiceAPI.getMovie(id);

    try {
      Response<Movie> movieResponse = callMovie.execute();
      Movie movie = movieResponse.body();

      MovieManual movieManual = new MovieManual();
      movieManual.setAdult(movie.getAdult());
      movieManual.setId(movie.getId());
      movieManual.setBudget(movie.getBudget());
      movieManual.setLanguage(movie.getOriginalLanguage());
      movieManual.setImdbId(movie.getImdbId());
      movieManual.setTitle(movie.getOriginalTitle());
      movieRepository.save(new Movie(movieManual));

      return movieResponse.body();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }

//    callMovie.enqueue(new Callback<Movie>() {
//      @Override
//      public void onResponse(Call<Movie> call, Response<Movie> response) {
//
//        if (!response.isSuccessful() || response.body() == null) {
//          System.err.println(response.code() + " - " + response.message());
//          return;
//        }
//
//        Movie movie = response.body();
//        MovieManual movieManual = new MovieManual();
//        movieManual.setAdult(movie.getAdult());
//        movieManual.setId(movie.getId());
//        movieManual.setBudget(movie.getBudget());
//        movieManual.setLanguage(movie.getOriginalLanguage());
//        movieManual.setImdbId(movie.getImdbId());
//        movieManual.setTitle(movie.getOriginalTitle());
//
//        movieRepository.save(new Movie(movieManual));
//        System.out.println(movie.toString());
//      }
//
//      @Override
//      public void onFailure(Call<Movie> call, Throwable t) {
//        System.err.println(t.getMessage());
//      }
//    });

  }

  @Override
  public void save(Movie movie) {
    movieRepository.save(movie);
  }
}
