package com.numble.reservation.domain.user.service;

import com.numble.reservation.domain.user.dto.request.JoinRequest;
import com.numble.reservation.domain.user.dto.request.LoginRequest;

public interface UserService <T>{
    void joinUser(JoinRequest request);
    void loginUser(LoginRequest request);
    T findUserByEmail(String email);
}
