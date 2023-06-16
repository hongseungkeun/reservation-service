package com.numble.reservation.domain.performance.service;

import com.numble.reservation.domain.performance.domain.Performance;
import com.numble.reservation.domain.performance.dto.request.PerformanceRegisterRequest;
import com.numble.reservation.domain.performance.dto.response.PerformanceRegisterResponse;
import com.numble.reservation.domain.performance.repository.PerformanceRepository;
import com.numble.reservation.domain.user.business.domain.BusinessUser;
import com.numble.reservation.domain.venue.domain.Venue;
import com.numble.reservation.domain.venue.service.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PerformanceService {
    private final VenueService venueService;
    private final PerformanceRepository performanceRepository;

    public PerformanceRegisterResponse registerPerformance(PerformanceRegisterRequest request, BusinessUser user) {
        Venue venue = venueService.findVenueById(request.venueId());
        Performance performance = performanceRepository.save(request.toPerformance(user, venue));
        return PerformanceRegisterResponse.from(performance.getPerformanceId());
    }
}
