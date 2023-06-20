package com.numble.reservation.domain.venue.seat.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    AVAILABLE("available"),
    OCCUPIED("occupied");

    private final String text;
}
