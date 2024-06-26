package com.example.dogsapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.dogsapp.domain.user.User;

public interface UserRepository extends JpaRepository<User, String> {
  UserDetails findByEmail(String email);
}
