package com.example.dogsapp.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.dogsapp.domain.dog.Dog;
import com.example.dogsapp.repositories.DogRepository;
import jakarta.persistence.EntityNotFoundException;

@RestController
class DogController {

  private final DogRepository repository;

  DogController(DogRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/dog")
  List<Dog> all() {
    return repository.findAll();
  }

  @PostMapping("/dog")
  Dog createDog(@RequestBody Dog newDog) {
    return repository.save(newDog);
  }

  @GetMapping("/dog/{id}")
  Dog findById(@PathVariable String id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
  }

  // TODO: Validar se é o dono que está alterando os dados do cachorro
  @PutMapping("/dog/{id}")
  Dog updateDog(@PathVariable String id, @RequestBody Dog newDog) {
    return repository.findById(id).map(dog -> {
      dog.setName(newDog.getName());
      dog.setAge(newDog.getAge());
      dog.setBreed(newDog.getBreed());
      return repository.save(dog);
    }).orElseThrow(() -> new EntityNotFoundException());
  }

  @DeleteMapping("/dog/{id}")
  void deleteDog(@PathVariable String id) {
    repository.deleteById(id);
  }
}
