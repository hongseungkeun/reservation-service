package com.numble.reservation.domain.user.controller;

import com.numble.reservation.domain.user.dto.request.JoinRequest;
import com.numble.reservation.domain.user.dto.request.LoginRequest;
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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    @Qualifier("userServiceImpl")
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> join(@Valid @RequestBody JoinRequest request){
        userService.joinUser(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody LoginRequest request){
        userService.loginUser(request);
        return ResponseEntity.ok().build();
    }
}
