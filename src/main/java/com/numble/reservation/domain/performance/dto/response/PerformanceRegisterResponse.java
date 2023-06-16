package com.numble.reservation.domain.performance.dto.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PROTECTED)
public record PerformanceRegisterResponse(
        Long id
) {
    public static PerformanceRegisterResponse from(Long id){
        return PerformanceRegisterResponse.builder()
                .id(id)
                .build();
    }
}
