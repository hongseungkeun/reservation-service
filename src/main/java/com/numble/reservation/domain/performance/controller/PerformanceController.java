package com.numble.reservation.domain.performance.controller;

import com.numble.reservation.domain.performance.dto.request.PerformanceRegisterRequest;
import com.numble.reservation.domain.performance.dto.response.PerformanceRegisterResponse;
import com.numble.reservation.domain.performance.service.PerformanceService;
import com.numble.reservation.domain.user.business.domain.BusinessUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/performances")
@RequiredArgsConstructor
public class PerformanceController {
    private final PerformanceService performanceService;

    @PostMapping
    public ResponseEntity<PerformanceRegisterResponse> register(@Valid @RequestBody PerformanceRegisterRequest request, BusinessUser user){
        PerformanceRegisterResponse response = performanceService.registerPerformance(request, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
