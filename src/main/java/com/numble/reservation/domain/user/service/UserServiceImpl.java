package com.numble.reservation.domain.user.service;

import com.numble.reservation.domain.user.domain.User;
import com.numble.reservation.domain.user.dto.request.JoinRequest;
import com.numble.reservation.domain.user.dto.request.LoginRequest;
import com.numble.reservation.domain.user.dto.response.JoinResponse;
import com.numble.reservation.domain.user.exception.UserNotFoundException;
import com.numble.reservation.domain.user.repository.UserRepository;
import com.numble.reservation.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    @Transactional
    public JoinResponse joinUser(JoinRequest request) {
        User user = request.toUserJoin();
        userRepository.save(user);
        return JoinResponse.toJoinResponse(request);
    }

    @Override
    public void loginUser(LoginRequest request) {
        userRepository.findByEmail(request.email())
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
    }
}
