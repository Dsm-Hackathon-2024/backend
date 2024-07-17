package org.example.backend.domain.invest.domain.repository;

import org.example.backend.domain.invest.domain.Invest;
import org.example.backend.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InvestRepository extends JpaRepository<Invest, Long> {
    List<Invest> findByUserId(Long userId);
    Optional<Invest> findByNameAndUser(String name, User user);
}
