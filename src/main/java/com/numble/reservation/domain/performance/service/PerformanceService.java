package com.numble.reservation.domain.performance.service;

import com.numble.reservation.domain.performance.domain.Performance;
import com.numble.reservation.domain.performance.dto.request.PerformanceRegisterRequest;
import com.numble.reservation.domain.performance.dto.response.PerformanceListResponse;
import com.numble.reservation.domain.performance.dto.response.PerformanceRegisterResponse;
import com.numble.reservation.domain.performance.dto.response.PerformanceSeatListResponse;
import com.numble.reservation.domain.performance.exception.PerformanceNotFoundException;
import com.numble.reservation.domain.performance.repository.PerformanceRepository;
import com.numble.reservation.domain.user.business.domain.BusinessUser;
import com.numble.reservation.domain.user.service.UserService;
import com.numble.reservation.domain.venue.domain.Venue;
import com.numble.reservation.domain.venue.service.VenueService;
import com.numble.reservation.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PerformanceService {
    private final VenueService venueService;
    @Qualifier("businessUserService")
    private final UserService userService;
    private final PerformanceRepository performanceRepository;

    @Transactional
    public PerformanceRegisterResponse registerPerformance(PerformanceRegisterRequest request, String email) {
        Venue venue = venueService.findVenueById(request.venueId());
        Performance performance = performanceRepository.save(request.toPerformance((BusinessUser) userService.findUserByEmail(email), venue));
        return PerformanceRegisterResponse.from(performance.getPerformanceId());
    }

    public Page<PerformanceListResponse> getPerformanceList(Pageable pageable) {
        List<PerformanceListResponse> response = performanceRepository.findAll(pageable)
                .stream()
                .map(PerformanceListResponse::from)
                .toList();
        return new PageImpl<>(response);
    }

    public PerformanceSeatListResponse getSeatListById(Long performanceId) {
        Performance performance = findPerformanceById(performanceId);
        return PerformanceSeatListResponse.from(performance);
    }

    private Performance findPerformanceById(Long performanceId){
        return performanceRepository.findById(performanceId)
                .orElseThrow(() -> new PerformanceNotFoundException(ErrorCode.PERFORMANCE_NOT_FOUND));
    }
}
