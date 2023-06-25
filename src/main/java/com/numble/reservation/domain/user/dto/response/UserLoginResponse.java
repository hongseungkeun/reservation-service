package com.numble.reservation.domain.user.dto.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record UserLoginResponse(
        String accessToken
) {
    public static UserLoginResponse from(String token) {
        return UserLoginResponse.builder()
                .accessToken(token)
                .build();
    }
}
