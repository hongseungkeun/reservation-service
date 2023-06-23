package com.numble.reservation.domain.performance.dto.request;

import com.numble.reservation.domain.performance.domain.Performance;
import com.numble.reservation.domain.user.business.domain.BusinessUser;
import com.numble.reservation.domain.venue.domain.Venue;

import java.util.Map;

public record PerformanceRegisterRequest(
        Long venueId,
        String name,
        int capacity,
        String date,
        String startTime,
        String endTime,
        Map<String, Integer> prices
) {
    public Performance toPerformance(BusinessUser user, Venue venue) {
        return Performance.builder()
                .name(this.name)
                .capacity(this.capacity)
                .date(this.date)
                .startTime(this.startTime)
                .endTime(this.endTime)
                .prices(this.prices)
                .businessUser(user)
                .venue(venue)
                .build();
    }
}
