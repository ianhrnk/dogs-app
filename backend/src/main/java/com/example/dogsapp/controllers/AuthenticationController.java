package com.example.dogsapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.dogsapp.domain.user.LoginDTO;
import com.example.dogsapp.domain.user.LoginResponseDTO;
import com.example.dogsapp.domain.user.RegisterDTO;
import com.example.dogsapp.domain.user.User;
import com.example.dogsapp.repositories.UserRepository;
import com.example.dogsapp.security.TokenService;
import jakarta.validation.Valid;

@RestController
public class AuthenticationController {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserRepository repository;

  @Autowired
  private TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody @Valid LoginDTO data) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
    var auth = this.authenticationManager.authenticate(usernamePassword);

    var token = tokenService.generateToken((User) auth.getPrincipal());

    return ResponseEntity.ok(new LoginResponseDTO(token));
  }

  @PostMapping("/register")
  public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
    if (this.repository.findByEmail(data.email()) != null)
      return ResponseEntity.badRequest().build();

    String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
    User newUser = new User(data.email(), encryptedPassword, data.role(), data.cep(), data.city(),
        data.state(), data.street(), data.streetNumber());

    this.repository.save(newUser);

    return ResponseEntity.ok().build();
  }
}
