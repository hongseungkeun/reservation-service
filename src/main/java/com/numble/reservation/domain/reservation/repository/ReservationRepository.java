package com.numble.reservation.domain.reservation.repository;

import com.numble.reservation.domain.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
