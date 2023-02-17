package com.example.jdbctest.controller;

import com.example.jdbctest.models.User;
import com.example.jdbctest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  private final UserService userService;

  @Autowired
  public MainController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/")
  public String home(Authentication authentication) {
    return "hi, " + authentication.getPrincipal().toString();
  }

  @GetMapping("/login")
  public String login() {

    return "Null";
  }

  @GetMapping("/user")
  public ResponseEntity user(Authentication authentication) {

    try {
      User user = userService.findByUsername(authentication.getName());
      return ResponseEntity.ok().body(user);

    } catch (UsernameNotFoundException e) {
      System.err.println(e.getMessage());
      return ResponseEntity.status(401).body("Error");
    }

  }

}
