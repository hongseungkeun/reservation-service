package com.numble.reservation.domain.performance.dto.response;

import com.numble.reservation.domain.performance.domain.Performance;
import com.numble.reservation.domain.venue.seat.domain.Seat;
import com.numble.reservation.domain.venue.seat.dto.response.SeatListResponse;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record PerformanceSeatListResponse(
        Long performanceId,
        List<SeatListResponse> seats
) {
    public static PerformanceSeatListResponse from(Performance performance) {
        return PerformanceSeatListResponse.builder()
                .performanceId(performance.getPerformanceId())
                .seats(getSeatList(performance.getVenue().getSeats()))
                .build();
    }

    private static List<SeatListResponse> getSeatList(List<Seat> seat) {
        return seat.stream()
                .map(SeatListResponse::from)
                .toList();
    }
}
