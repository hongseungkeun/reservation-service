package com.numble.reservation.domain.venue.seat.domain;

import com.numble.reservation.domain.reservation.domain.Reservation;
import com.numble.reservation.domain.venue.domain.Venue;
import com.numble.reservation.domain.venue.seat.data.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;
    @Column(nullable = false)
    private String seatNumber;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private String seatType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @Builder
    public Seat(String seatNumber,
                Status status,
                String seatType,
                Venue venue) {
        this.seatNumber = seatNumber;
        this.status = status;
        this.seatType = seatType;
        this.venue = venue;
    }

    public void seatChangeOccupied(){
        this.status = Status.OCCUPIED;
    }
}
