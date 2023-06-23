package com.numble.reservation.domain.venue.seat.dto.request;

import com.numble.reservation.domain.venue.domain.Venue;
import com.numble.reservation.domain.venue.seat.data.Status;
import com.numble.reservation.domain.venue.seat.domain.Seat;

public record SeatRegisterRequest(
        String seatNumber,
        String seatType
) {
    public Seat toSeat(Venue venue) {
        return Seat.builder()
                .seatNumber(this.seatNumber)
                .status(Status.AVAILABLE)
                .seatType(this.seatType)
                .venue(venue)
                .build();
    }
}
