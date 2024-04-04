package com.example.dogsapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dogsapp.domain.dog.Dog;

public interface DogRepository extends JpaRepository<Dog, String> {
}
