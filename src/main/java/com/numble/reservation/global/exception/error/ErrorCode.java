package com.numble.reservation.global.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수가 없습니다."),
    VENUE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 공연장을 찾을 수가 없습니다");

    private final HttpStatus status;
    private final String message;
}
