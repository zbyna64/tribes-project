package com.example.jdbctest.service;

import com.example.jdbctest.models.SecuredUser;
import com.example.jdbctest.models.User;
import com.example.jdbctest.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;

  }


  public User findByUsername(String username) throws UsernameNotFoundException {

    Optional<User> optUser = userRepository.findUserByUsername(username);

    if (!optUser.isPresent()) {
      throw new UsernameNotFoundException(username + " not found!");
    }
    return optUser.get();
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = findByUsername(username);
    return new SecuredUser(user);
  }

  public boolean userExists(String username) throws UsernameNotFoundException {

    Optional<User> optUser = userRepository.findUserByUsername(username);

    return optUser.isPresent();
  }

  public void saveUser(User user) throws Exception {

    if (userExists(user.getUsername())) {
      throw new Exception();

    } else {
      user.setAuthorities("ROLE_USER,READ");
      userRepository.save(new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getAuthorities()));
    }


  }
}
