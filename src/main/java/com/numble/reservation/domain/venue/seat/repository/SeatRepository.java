package com.numble.reservation.domain.venue.seat.repository;

import com.numble.reservation.domain.venue.seat.data.Status;
import com.numble.reservation.domain.venue.seat.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    Optional<Seat> findBySeatIdAndStatus(Long id, Status status);
}
