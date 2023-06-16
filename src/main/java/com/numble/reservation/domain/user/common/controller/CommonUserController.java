package com.numble.reservation.domain.user.common.controller;

import com.numble.reservation.domain.user.dto.request.UserJoinRequest;
import com.numble.reservation.domain.user.dto.response.UserJoinResponse;
import com.numble.reservation.domain.user.service.UserService;
import com.numble.reservation.domain.user.dto.request.UserLoginRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class CommonUserController {
    @Qualifier("commonUserService")
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserJoinResponse> join(@Valid @RequestBody UserJoinRequest request){
        UserJoinResponse response = userService.joinUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody UserLoginRequest request){
        userService.loginUser(request);
        return ResponseEntity.ok().build();
    }
}
