package com.numble.reservation.domain.reservation.service;

import com.numble.reservation.domain.performance.domain.Performance;
import com.numble.reservation.domain.performance.service.PerformanceService;
import com.numble.reservation.domain.reservation.domain.Reservation;
import com.numble.reservation.domain.reservation.dto.request.ReservationCreateRequest;
import com.numble.reservation.domain.reservation.dto.response.ReservationCreateResponse;
import com.numble.reservation.domain.reservation.repository.ReservationRepository;
import com.numble.reservation.domain.user.common.domain.CommonUser;
import com.numble.reservation.domain.user.service.UserService;
import com.numble.reservation.domain.venue.seat.domain.Seat;
import com.numble.reservation.domain.venue.seat.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReservationsService {
    @Qualifier("commonUserService")
    private final UserService userService;
    private final PerformanceService performanceService;
    private final SeatService seatService;
    private final ReservationRepository reservationRepository;

    @Transactional
    public ReservationCreateResponse createReservation(Long performanceId, ReservationCreateRequest request, CommonUser user) {
        Performance performance = performanceService.findPerformanceById(performanceId);
        List<Seat> seats = seatService.isSeatsAvailable(request.getSeatIds());
        Reservation reservation = reservationRepository.save(request.toReservation(user, performance, seats));
        return ReservationCreateResponse.from(reservation.getReservationId());
    }
}
