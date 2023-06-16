package com.numble.reservation.domain.performance.domain;

import com.numble.reservation.domain.user.business.domain.BusinessUser;
import com.numble.reservation.domain.venue.domain.Venue;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long performanceId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int capacity;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String startTime;
    @Column(nullable = false)
    private String endTime;
    @ElementCollection
    @CollectionTable(name = "price", joinColumns = @JoinColumn(name = "performance_id"))
    private Map<String, Integer> prices = new HashMap<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BusinessUser businessUser;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @Builder
    public Performance(String name,
                       int capacity,
                       String date,
                       String startTime,
                       String endTime,
                       Map<String, Integer> prices,
                       BusinessUser businessUser,
                       Venue venue) {
        this.name = name;
        this.capacity = capacity;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.prices = prices;
        this.businessUser = businessUser;
        this.venue = venue;
    }
}
