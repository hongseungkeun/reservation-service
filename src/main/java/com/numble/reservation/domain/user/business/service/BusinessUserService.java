package com.numble.reservation.domain.user.business.service;

import com.numble.reservation.domain.user.business.domain.BusinessUser;
import com.numble.reservation.domain.user.business.repository.BusinessUserRepository;
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
public class BusinessUserService implements UserService {
    private final BusinessUserRepository userRepository;

    @Override
    @Transactional
    public void joinUser(JoinRequest request) {
        BusinessUser user = request.toBusinessJoin();
        userRepository.save(user);
    }

    @Override
    public void loginUser(LoginRequest request) {
        findUserByEmail(request.email());
    }

    @Override
    public BusinessUser findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
    }
}
