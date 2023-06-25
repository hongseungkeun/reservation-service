package com.numble.reservation.domain.venue.seat.exception;

import com.numble.reservation.global.exception.CustomException;
import com.numble.reservation.global.exception.error.ErrorCode;

public class SeatNotFoundException extends CustomException {
    public SeatNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
