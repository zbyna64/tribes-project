package com.gfa.springadvanced.controllers;

import com.gfa.springadvanced.models.User;
import com.gfa.springadvanced.models.fromJson.Movie;
import com.gfa.springadvanced.services.MovieService;
import com.gfa.springadvanced.services.TokenService;
import com.gfa.springadvanced.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  private final MovieService movieService;
  private final TokenService tokenService;
  private final UserService userService;

  @Autowired
  public MainController(MovieService movieService, TokenService tokenService,
      UserService userService) {
    this.movieService = movieService;
    this.tokenService = tokenService;
    this.userService = userService;
  }


  @GetMapping("/{id}")
  public Movie getPost(@PathVariable("id") Long id) {
    return movieService.getMovie(id);
  }

  @GetMapping("/list")
  public List<Movie> list() {
    return movieService.listAllMovies();
  }

  @GetMapping("/home")
  public String home(Authentication authentication) {
    UserDetails user = userService.loadUserByUsername(authentication.getName());
//    String token = tokenService.generateToken(authentication);
    return "hello " + user.getUsername() + user.getPassword();
  }

}
