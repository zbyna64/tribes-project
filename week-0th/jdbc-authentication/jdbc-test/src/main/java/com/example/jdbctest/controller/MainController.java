package com.example.jdbctest.controller;

import com.example.jdbctest.models.User;
import com.example.jdbctest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

  private final UserService userService;

  @Autowired
  public MainController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/")
  @ResponseBody
  public String home(Authentication authentication) {
    return "hi, " + authentication.getPrincipal().toString();
  }

  @GetMapping("/register")
  public String register(Model model) {
    return "register";
  }

  @PostMapping("/register")
  public String registerUser(@RequestParam String username, @RequestParam String password) {
    User user = new User(username, password);
    try {
      userService.saveUser(user);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return "redirect:/login";
  }

  @GetMapping("/user")
  @ResponseBody
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
