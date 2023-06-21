package com.numble.reservation.domain.venue.seat.dto.response;

import com.numble.reservation.domain.venue.seat.domain.Seat;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record SeatListResponse(
        Long seatId,
        String seatNumber,
        String status
) {
    public static SeatListResponse from(Seat seat){
        return SeatListResponse.builder()
                .seatId(seat.getSeatId())
                .seatNumber(seat.getSeatNumber())
                .status(seat.getStatus().getText())
                .build();
    }
}
