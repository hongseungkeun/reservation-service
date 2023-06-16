package com.numble.reservation.domain.performance.repository;

import com.numble.reservation.domain.performance.domain.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {
}
