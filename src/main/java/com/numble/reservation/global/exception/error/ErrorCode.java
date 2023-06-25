package com.numble.reservation.global.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    SEAT_ALREADY_OCCUPIED(HttpStatus.BAD_REQUEST, "해당 좌석은 이미 예매 완료된 좌석입니다"),
    PASSWORD_MISMATCH(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수가 없습니다"),
    VENUE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 공연장을 찾을 수가 없습니다"),
    PERFORMANCE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 공연을 찾을 수가 없습니다");

    private final HttpStatus status;
    private final String message;
}
