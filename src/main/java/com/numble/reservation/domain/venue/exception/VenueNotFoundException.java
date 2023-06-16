package com.numble.reservation.domain.venue.exception;

import com.numble.reservation.global.exception.CustomException;
import com.numble.reservation.global.exception.error.ErrorCode;

public class VenueNotFoundException extends CustomException {
    public VenueNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
