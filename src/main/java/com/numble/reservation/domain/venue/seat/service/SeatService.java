package com.numble.reservation.domain.venue.seat.service;

import com.numble.reservation.domain.venue.domain.Venue;
import com.numble.reservation.domain.venue.seat.dto.request.SeatRegisterRequest;
import com.numble.reservation.domain.venue.seat.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;

    public void save(List<SeatRegisterRequest> seats, Venue venue){
        seatRepository.saveAll(seats.stream().map(s -> s.toSeat(venue)).toList());
    }
}
