package com.numble.reservation.domain.user.common.service;

import com.numble.reservation.domain.user.common.domain.CommonUser;
import com.numble.reservation.domain.user.common.repository.CommonUserRepository;
import com.numble.reservation.domain.user.dto.request.JoinRequest;
import com.numble.reservation.domain.user.dto.request.LoginRequest;
import com.numble.reservation.domain.user.exception.UserNotFoundException;
import com.numble.reservation.domain.user.service.UserService;
import com.numble.reservation.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommonUserService implements UserService {
    private final CommonUserRepository userRepository;

    @Override
    @Transactional
    public void joinUser(JoinRequest request) {
        CommonUser user = request.toUserJoin();
        userRepository.save(user);
    }

    @Override
    public void loginUser(LoginRequest request) {
        findUserByEmail(request.email());
    }

    @Override
    public CommonUser findUserByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
    }
}
