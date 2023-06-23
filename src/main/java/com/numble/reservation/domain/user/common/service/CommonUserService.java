package com.numble.reservation.domain.user.common.service;

import com.numble.reservation.domain.user.common.domain.CommonUser;
import com.numble.reservation.domain.user.common.repository.CommonUserRepository;
import com.numble.reservation.domain.user.dto.request.UserJoinRequest;
import com.numble.reservation.domain.user.dto.request.UserLoginRequest;
import com.numble.reservation.domain.user.dto.response.UserJoinResponse;
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
    public UserJoinResponse joinUser(UserJoinRequest request) {
        CommonUser user = userRepository.save(request.toCommonUser());
        return UserJoinResponse.from(user.getUserId());
    }

    @Override
    public void loginUser(UserLoginRequest request) {
        findUserByEmail(request.email());
    }

    @Override
    public CommonUser findUserByEmail(String email) {
        return userRepository.findByUserInfoEmail(email)
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
    }
}
