package com.example.dogsapp.domain.breed;

import java.util.List;
import com.example.dogsapp.domain.dog.Dog;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Breed {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "breed")
  @JsonIgnore
  private List<Dog> dogs;

  public Breed(Long id) {
    this.id = id;
  }
}
