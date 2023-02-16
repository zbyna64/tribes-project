package com.gfa.springadvanced.config;

import static org.springframework.security.config.Customizer.*;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  @Value("${jwt.key}")
  private String jwtKey;


  @Bean
  public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
    UserDetails admin = User.withDefaultPasswordEncoder()
        .username("zbyna")
        .password("pass")
        .authorities("READ", "ROLE_ADMIN")
        .build();

    UserDetails user = User.withDefaultPasswordEncoder()
        .username("user")
        .password("pass")
        .authorities("READ", "ROLE_USER")
        .build();

    UserDetails low = User.withDefaultPasswordEncoder()
        .username("low")
        .password("pass")
        .authorities("READ", "ROLE_LOW")
        .build();

    return new InMemoryUserDetailsManager(user, admin, low);
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable())
        .authorizeRequests(auth -> auth
            .antMatchers("/token").permitAll()
            .antMatchers("/home").hasRole("USER")
            .antMatchers("/500").hasAuthority("SCOPE_ROLE_LOW")
            .antMatchers("/501").hasAuthority("SCOPE_ROLE_USER")
            .antMatchers("/502").hasAuthority("SCOPE_ROLE_ADMIN")
            .anyRequest().hasAuthority("SCOPE_READ")
        )
        .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
        .sessionManagement(
            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .formLogin()
        .and()
        .httpBasic(withDefaults())
        .build();

  }

  @Bean
  JwtDecoder jwtDecoder() {
    byte[] bytes = jwtKey.getBytes();
    SecretKeySpec originalKey = new SecretKeySpec(bytes, 0, bytes.length, "RSA");
    return NimbusJwtDecoder.withSecretKey(originalKey).macAlgorithm(MacAlgorithm.HS256).build();
  }


  @Bean
  JwtEncoder jwtEncoder() {
    return new NimbusJwtEncoder(new ImmutableSecret<>(jwtKey.getBytes()));
  }

}
