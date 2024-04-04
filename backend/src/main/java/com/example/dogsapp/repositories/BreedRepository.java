package com.example.dogsapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dogsapp.domain.breed.Breed;

public interface BreedRepository extends JpaRepository<Breed, Long> {
}
