package org.example.backend.domain.invest.domain.repository;

import org.example.backend.domain.invest.domain.Invest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestRepository extends JpaRepository<Invest, Long> {
}
