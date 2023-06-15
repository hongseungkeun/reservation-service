package com.numble.reservation.domain.user.service;

import com.numble.reservation.domain.user.dto.request.JoinRequest;
import com.numble.reservation.domain.user.dto.request.LoginRequest;
import com.numble.reservation.domain.user.dto.response.JoinResponse;

public interface UserService <T>{
    JoinResponse joinUser(JoinRequest request);
    void loginUser(LoginRequest request);
}
