package com.gfa.springadvanced.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationProviderConfig implements AuthenticationProvider {

  private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

  public AuthenticationProviderConfig(InMemoryUserDetailsManager inMemoryUserDetailsManager) {
    this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    String username = authentication.getName();
    String password = authentication.getCredentials().toString();

    if (username == null) {
      throw new AuthenticationException("Could not login") {
      };
    }

    UserDetails user = inMemoryUserDetailsManager.loadUserByUsername(username);

    return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return false;
  }
}
