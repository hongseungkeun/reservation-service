package com.numble.reservation.domain.venue.dto.request;

import com.numble.reservation.domain.user.business.domain.BusinessUser;
import com.numble.reservation.domain.venue.domain.Venue;
import com.numble.reservation.domain.venue.seat.dto.request.SeatRegisterRequest;

import java.util.List;

public record VenueRegisterRequest(
        String name,
        int capacity,
        String venuesType,
        String possibleTimes,
        List<SeatRegisterRequest> seats
) {
    public Venue toVenue(BusinessUser user){
        return Venue.builder()
                .name(this.name)
                .capacity(this.capacity)
                .venuesType(this.venuesType)
                .possibleTimes(this.possibleTimes)
                .user(user)
                .build();
    }
}
