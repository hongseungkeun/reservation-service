package com.numble.reservation.domain.performance.dto.response;

import com.numble.reservation.domain.performance.domain.Performance;
import com.numble.reservation.domain.venue.seat.data.Status;
import com.numble.reservation.domain.venue.seat.domain.Seat;
import lombok.AccessLevel;
import lombok.Builder;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Builder(access = AccessLevel.PRIVATE)
public record PerformanceListResponse(
        Long performanceId,
        String title,
        String date,
        String time,
        String venue,
        int ticketPrice,
        int availableSeats
) {
    public static PerformanceListResponse from(Performance performance){
        return PerformanceListResponse.builder()
                .performanceId(performance.getPerformanceId())
                .title(performance.getName())
                .date(performance.getDate())
                .time(performance.getStartTime())
                .venue(performance.getVenue().getName())
                .ticketPrice(getMinTicketPrice(performance.getPrices()))
                .availableSeats(getAvailableSeats(performance.getVenue().getSeats()))
                .build();
    }

    private static int getMinTicketPrice(Map<String, Integer> prices){
        return Collections.min(prices.values());
    }

    private static int getAvailableSeats(List<Seat> seat){
        return seat.stream()
                .filter(s -> s.getStatus().equals(Status.AVAILABLE))
                .toList()
                .size();
    }
}
