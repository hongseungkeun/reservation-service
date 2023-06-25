package com.numble.reservation.domain.user.service;

import com.numble.reservation.domain.user.dto.request.UserJoinRequest;
import com.numble.reservation.domain.user.dto.request.UserLoginRequest;
import com.numble.reservation.domain.user.dto.response.UserJoinResponse;
import com.numble.reservation.domain.user.dto.response.UserLoginResponse;

public interface UserService <T>{
    UserJoinResponse joinUser(UserJoinRequest request);
    UserLoginResponse loginUser(UserLoginRequest request);
    T findUserByEmail(String email);
}
