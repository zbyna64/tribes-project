package com.example.jdbctest;

import com.example.jdbctest.models.User;
import com.example.jdbctest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JdbcTestApplication implements CommandLineRunner {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Autowired
  public JdbcTestApplication(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  public static void main(String[] args) {
    SpringApplication.run(JdbcTestApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Password encoded: " );
    System.out.println(passwordEncoder.encode("pass"));

    userRepository.save(new User("zbyna", "$2a$10$EeTa9v4A3.7ZVJHm/6Bh4.s2pBu7kOeaOlahmZRmxpKZMObob.qS2", "ROLE_USER,READ"));

  }
}
