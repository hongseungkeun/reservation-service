package com.numble.reservation.domain.performance.controller;

import com.numble.reservation.domain.performance.dto.request.PerformanceRegisterRequest;
import com.numble.reservation.domain.performance.dto.response.PerformanceListResponse;
import com.numble.reservation.domain.performance.dto.response.PerformanceRegisterResponse;
import com.numble.reservation.domain.performance.dto.response.PerformanceSeatListResponse;
import com.numble.reservation.domain.performance.service.PerformanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/performances")
@RequiredArgsConstructor
public class PerformanceController {
    private final PerformanceService performanceService;

    @PostMapping("/{email}")
    public ResponseEntity<PerformanceRegisterResponse> register(@Valid @RequestBody PerformanceRegisterRequest request, @PathVariable String email) {
        PerformanceRegisterResponse response = performanceService.registerPerformance(request, email);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<PerformanceListResponse>> getList(@PageableDefault(sort = "performanceId", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<PerformanceListResponse> response = performanceService.getPerformanceList(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{performanceId}/seats")
    public ResponseEntity<PerformanceSeatListResponse> getSeatList(@PathVariable Long performanceId) {
        PerformanceSeatListResponse response = performanceService.getSeatListById(performanceId);
        return ResponseEntity.ok(response);
    }
}
