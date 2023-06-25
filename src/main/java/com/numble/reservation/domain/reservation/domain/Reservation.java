package com.numble.reservation.domain.reservation.domain;

import com.numble.reservation.domain.performance.domain.Performance;
import com.numble.reservation.domain.user.common.domain.CommonUser;
import com.numble.reservation.domain.venue.seat.domain.Seat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    @Column(nullable = false)
    private int totalPrice;
    @Embedded
    private PaymentInfo paymentInfo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CommonUser user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Performance performance;
    @OneToMany(mappedBy = "reservation")
    private List<Seat> seats = new ArrayList<>();

    @Builder
    public Reservation(int totalPrice,
                       PaymentInfo paymentInfo,
                       CommonUser user,
                       Performance performance,
                       List<Seat> seats) {
        this.totalPrice = totalPrice;
        this.paymentInfo = paymentInfo;
        this.user = user;
        this.performance = performance;
        this.seats = seats;
    }
}
