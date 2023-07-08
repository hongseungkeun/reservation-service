package com.numble.reservation.domain.reservation.controller;

import com.numble.reservation.domain.reservation.dto.request.ReservationCreateRequest;
import com.numble.reservation.domain.reservation.dto.response.ReservationCreateResponse;
import com.numble.reservation.domain.reservation.service.ReservationsService;
import com.numble.reservation.global.security.UserPrincipal;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationsService reservationsService;

    @PostMapping("/{performanceId}")
    public ResponseEntity<ReservationCreateResponse> create(@PathVariable Long performanceId, @Valid @RequestBody ReservationCreateRequest request,
                                                            @AuthenticationPrincipal UserPrincipal.CommonUserPrincipal user){
        ReservationCreateResponse response = reservationsService.createReservation(performanceId, request, user.user());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
