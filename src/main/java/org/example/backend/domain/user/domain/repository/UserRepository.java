package org.example.backend.domain.user.domain.repository;

import org.example.backend.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String username);
    boolean existsByName(String telephoneNumber);
}
