package com.numble.reservation.domain.venue.domain;

import com.numble.reservation.domain.user.business.domain.BusinessUser;
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
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venueId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int capacity;
    @Column(nullable = false)
    private String venuesType;
    @Column(nullable = false)
    private String possibleTimes;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BusinessUser user;
    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();

    @Builder
    public Venue(String name,
                 int capacity,
                 String possibleTimes,
                 BusinessUser user,
                 List<Seat> seats) {
        this.name = name;
        this.capacity = capacity;
        this.possibleTimes = possibleTimes;
        this.user = user;
        this.seats = seats;
    }
}
