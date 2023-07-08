package com.numble.reservation.domain.user.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ROLE_COMMON("사용자", "customUserDetailsService.CommonUserDetailsService"),
    ROLE_VENUE_ADMIN("공연장 관리자", "customUserDetailsService.BusinessUserDetailsService"),
    ROLE_PERFORMANCE_ADMIN("공연 관리자", "customUserDetailsService.BusinessUserDetailsService");

    private final String role;
    private final String detailsService;
}
