package com.numble.reservation.domain.venue.controller;

import com.numble.reservation.domain.user.business.domain.BusinessUser;
import com.numble.reservation.domain.venue.dto.request.VenueRegisterRequest;
import com.numble.reservation.domain.venue.dto.response.VenueRegisterResponse;
import com.numble.reservation.domain.venue.service.VenueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venues")
@RequiredArgsConstructor
public class VenueController {
    private final VenueService venueService;

    @PostMapping
    public ResponseEntity<VenueRegisterResponse> register(@Valid @RequestBody VenueRegisterRequest request, BusinessUser user){
        VenueRegisterResponse response = venueService.registerVenue(request, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
