package com.numble.reservation.domain.user.business.service;

import com.numble.reservation.domain.user.business.domain.BusinessUser;
import com.numble.reservation.domain.user.business.repository.BusinessUserRepository;
import com.numble.reservation.domain.user.dto.request.UserJoinRequest;
import com.numble.reservation.domain.user.dto.request.UserLoginRequest;
import com.numble.reservation.domain.user.dto.response.UserJoinResponse;
import com.numble.reservation.domain.user.dto.response.UserLoginResponse;
import com.numble.reservation.domain.user.exception.UserNotFoundException;
import com.numble.reservation.domain.user.service.UserService;
import com.numble.reservation.global.exception.error.ErrorCode;
import com.numble.reservation.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BusinessUserService implements UserService {
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final BusinessUserRepository userRepository;

    @Override
    @Transactional
    public UserJoinResponse joinUser(UserJoinRequest request) {
        BusinessUser user = userRepository.save(request.toBusinessUser(passwordEncoder));
        return UserJoinResponse.from(user.getUserId());
    }

    @Override
    public UserLoginResponse loginUser(UserLoginRequest request) {
        BusinessUser user = findUserByEmail(request.email());
        user.getUserInfo().isPossibleLogin(passwordEncoder, request.password());

        String token = jwtTokenProvider.createToken(user.getUserInfo().getEmail(), user.getUserInfo().getType());
        return UserLoginResponse.from(token);
    }

    @Override
    public BusinessUser findUserByEmail(String email) {
        return userRepository.findByUserInfoEmail(email)
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
    }
}
