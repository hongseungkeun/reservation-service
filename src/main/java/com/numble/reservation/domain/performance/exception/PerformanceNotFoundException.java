package com.numble.reservation.domain.performance.exception;

import com.numble.reservation.global.exception.CustomException;
import com.numble.reservation.global.exception.error.ErrorCode;

public class PerformanceNotFoundException extends CustomException {
    public PerformanceNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
