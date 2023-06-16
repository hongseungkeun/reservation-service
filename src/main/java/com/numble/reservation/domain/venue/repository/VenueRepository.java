package com.numble.reservation.domain.venue.repository;

import com.numble.reservation.domain.venue.domain.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
