package com.numble.reservation.domain.venue.seat.dto.request;

import com.numble.reservation.domain.venue.seat.domain.Seat;

public record SeatRegisterRequest(
        String seatNumber,
        String seatType
) {
    public Seat toSeat(){
        return Seat.builder()
                .seatNumber(this.seatNumber)
                .seatType(this.seatType)
                .build();
    }
}
