package com.numble.reservation.domain.reservation.dto.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record ReservationCreateResponse(
        Long id
) {
    public static ReservationCreateResponse from(Long id) {
        return ReservationCreateResponse.builder()
                .id(id)
                .build();
    }
}
