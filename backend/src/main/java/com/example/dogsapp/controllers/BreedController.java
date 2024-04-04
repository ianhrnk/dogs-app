package com.example.dogsapp.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.dogsapp.domain.breed.Breed;
import com.example.dogsapp.repositories.BreedRepository;
import jakarta.persistence.EntityNotFoundException;

@RestController
class BreedController {

  private final BreedRepository repository;

  BreedController(BreedRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/breed")
  List<Breed> all() {
    return repository.findAll();
  }

  @GetMapping("/breed/{id}")
  Breed findById(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
  }
}
