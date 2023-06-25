package com.numble.reservation.domain.reservation.dto.request;

import com.numble.reservation.domain.performance.domain.Performance;
import com.numble.reservation.domain.reservation.domain.PaymentInfo;
import com.numble.reservation.domain.reservation.domain.Reservation;
import com.numble.reservation.domain.user.common.domain.CommonUser;
import com.numble.reservation.domain.venue.seat.domain.Seat;
import com.numble.reservation.domain.venue.seat.dto.request.SeatReservationCreateRequest;

import java.util.List;

public record ReservationCreateRequest(
    List<SeatReservationCreateRequest> seats,
    int totalPrice,
    ReservationPaymentInfoCreateRequest paymentInfo
) {
    public Reservation toReservation(CommonUser user, Performance performance, List<Seat> seats) {
        return Reservation.builder()
                .totalPrice(this.totalPrice)
                .paymentInfo(PaymentInfo.builder()
                        .paymentMethod(this.paymentInfo.paymentMethod())
                        .cardNumber(this.paymentInfo.cardNumber())
                        .cardExpiration(this.paymentInfo.cardExpiration())
                        .cardCVV(this.paymentInfo.cardCVV())
                        .build())
                .user(user)
                .performance(performance)
                .seats(seats)
                .build();
    }

    public List<Long> getSeatIds(){
        return this.seats().stream()
                .mapToLong(SeatReservationCreateRequest::seatId)
                .boxed()
                .toList();
    }
}
