package com.numble.reservation.domain.user.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ROLE_COMMON("사용자"),
    ROLE_VENUE_ADMIN("공연장 관리자"),
    ROLE_PERFORMANCE_ADMIN("공연 관리자");

    private final String role;
}
