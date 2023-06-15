package com.numble.reservation.domain.user.service;

import com.numble.reservation.domain.user.dto.request.JoinRequest;
import com.numble.reservation.domain.user.dto.request.LoginRequest;

public interface UserService {
    void joinUser(JoinRequest request);
    void loginUser(LoginRequest request);
}
