package com.numble.reservation.domain.venue.dto.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record VenueRegisterResponse(
        Long id
) {
    public static VenueRegisterResponse from(Long id){
        return VenueRegisterResponse.builder()
                .id(id)
                .build();
    }
}
