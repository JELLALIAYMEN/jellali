package com.example.jwtsecurity;

import com.example.jwtsecurity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRep extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
