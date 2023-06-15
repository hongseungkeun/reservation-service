package com.numble.reservation.domain.user.exception;

import com.numble.reservation.global.exception.CustomException;
import com.numble.reservation.global.exception.error.ErrorCode;

public class UserNotFoundException extends CustomException {
    public UserNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
