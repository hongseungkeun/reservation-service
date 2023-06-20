package com.numble.reservation.domain.venue.service;

import com.numble.reservation.domain.user.business.domain.BusinessUser;
import com.numble.reservation.domain.user.service.UserService;
import com.numble.reservation.domain.venue.domain.Venue;
import com.numble.reservation.domain.venue.dto.request.VenueRegisterRequest;
import com.numble.reservation.domain.venue.dto.response.VenueRegisterResponse;
import com.numble.reservation.domain.venue.exception.VenueNotFoundException;
import com.numble.reservation.domain.venue.repository.VenueRepository;
import com.numble.reservation.domain.venue.seat.service.SeatService;
import com.numble.reservation.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VenueService {
    @Qualifier("businessUserService")
    private final UserService userService;
    private final SeatService seatService;
    private final VenueRepository venueRepository;

    @Transactional
    public VenueRegisterResponse registerVenue(VenueRegisterRequest request, String email) {
        Venue venue = venueRepository.save(request.toVenue((BusinessUser) userService.findUserByEmail(email)));
        seatService.save(request.seats(), venue);
        return VenueRegisterResponse.from(venue.getVenueId());
    }

    public Venue findVenueById(Long id){
        return venueRepository.findById(id)
                .orElseThrow(() -> new VenueNotFoundException(ErrorCode.VENUE_NOT_FOUND));
    }
}
