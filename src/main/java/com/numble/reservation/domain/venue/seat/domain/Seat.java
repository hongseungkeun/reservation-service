package com.numble.reservation.domain.venue.seat.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
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
    @ColumnDefault("0")
    private boolean status;
    @Column(nullable = false)
    private String seatType;

    @Builder
    public Seat(Long seatId,
                String seatNumber,
                boolean status,
                String seatType) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.status = status;
        this.seatType = seatType;
    }
}
