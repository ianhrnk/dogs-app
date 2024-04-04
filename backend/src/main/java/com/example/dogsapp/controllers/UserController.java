package com.example.dogsapp.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.dogsapp.domain.user.User;
import com.example.dogsapp.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@RestController
class UserController {

  private final UserRepository repository;

  UserController(UserRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/user")
  List<User> all() {
    return repository.findAll();
  }

  @GetMapping("/user/{id}")
  User findById(@PathVariable String id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
  }

  // // TODO: Verificar se o usuário que está alterando é realmente ele
  // @PutMapping("/user")
  // User updateUser(@RequestBody User newUser) {
  // // TODO: Substituir o new user id pelo id do JWT Token
  // return repository.findById(newUser.getId()).map(user -> {
  // user.setCep(newUser.getCep());
  // user.setCity(newUser.getCity());
  // user.setState(newUser.getState());
  // user.setStreet(newUser.getStreet());
  // return repository.save(user);
  // }).orElseThrow(() -> new EntityNotFoundException());
  // }

  // @DeleteMapping("/user/{id}")
  // void deleteUser(@PathVariable Long id) {
  // repository.deleteById(id);
  // }
}
