package com.numble.reservation.domain.user.exception;

import com.numble.reservation.global.exception.CustomException;
import com.numble.reservation.global.exception.error.ErrorCode;

public class PasswordMismatchException extends CustomException {
    public PasswordMismatchException(ErrorCode errorCode) {
        super(errorCode);
    }
}
