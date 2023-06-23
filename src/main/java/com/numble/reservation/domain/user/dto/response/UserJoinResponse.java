package com.numble.reservation.domain.user.dto.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record UserJoinResponse(
        Long id
) {
    public static UserJoinResponse from(Long id) {
        return UserJoinResponse.builder()
                .id(id)
                .build();
    }
}
