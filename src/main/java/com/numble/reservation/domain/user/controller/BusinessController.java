package com.numble.reservation.domain.user.controller;

import com.numble.reservation.domain.user.dto.request.JoinRequest;
import com.numble.reservation.domain.user.dto.request.LoginRequest;
import com.numble.reservation.domain.user.dto.response.BusinessJoinResponse;
import com.numble.reservation.domain.user.dto.response.JoinResponse;
import com.numble.reservation.domain.user.dto.response.UserJoinResponse;
import com.numble.reservation.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/businesses")
@RequiredArgsConstructor
public class BusinessController {
    @Qualifier("BusinessServiceImpl")
    private final UserService userService;

    @PostMapping
    public ResponseEntity<BusinessJoinResponse> join(@Valid @RequestBody JoinRequest request){
        JoinResponse response = userService.joinUser(request);

        return ResponseEntity.ok(response.toBusinessJoinResponse());
    }

    @PostMapping("/login")
    public ResponseEntity<UserJoinResponse> login(@Valid @RequestBody LoginRequest request){
        userService.loginUser(request);

        return ResponseEntity.ok().build();
    }
}
