package com.numble.reservation.domain.venue.seat.repository;

import com.numble.reservation.domain.venue.seat.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
