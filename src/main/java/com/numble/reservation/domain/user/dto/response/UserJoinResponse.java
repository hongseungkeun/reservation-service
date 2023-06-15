package com.numble.reservation.domain.user.dto.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PUBLIC)
public record UserJoinResponse(
        String name,
        String email,
        String password
) {
}
