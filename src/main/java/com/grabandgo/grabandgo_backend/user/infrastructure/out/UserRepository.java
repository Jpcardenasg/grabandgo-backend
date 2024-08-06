package com.grabandgo.grabandgo_backend.user.infrastructure.out;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grabandgo.grabandgo_backend.user.domain.User;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}