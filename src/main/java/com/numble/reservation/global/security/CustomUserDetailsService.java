package com.numble.reservation.global.security;

import com.numble.reservation.domain.user.business.domain.BusinessUser;
import com.numble.reservation.domain.user.business.repository.BusinessUserRepository;
import com.numble.reservation.domain.user.common.domain.CommonUser;
import com.numble.reservation.domain.user.common.repository.CommonUserRepository;
import com.numble.reservation.domain.user.exception.UserNotFoundException;
import com.numble.reservation.global.exception.error.ErrorCode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomUserDetailsService {
    @Service
    @RequiredArgsConstructor
    @Transactional(readOnly = true)
    @Qualifier("commonUserDetailsService")
    public static class CommonUserDetailsService implements UserDetailsService {
        private final CommonUserRepository commonUserRepository;

        @Override
        public UserDetails loadUserByUsername(String email) {
            CommonUser user = commonUserRepository.findByUserInfoEmail(email)
                    .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
            return new UserPrincipal.CommonUserPrincipal
                    .CommonUserPrincipalBuilder()
                    .user(user)
                    .build();
        }
    }

    @Service
    @RequiredArgsConstructor
    @Transactional(readOnly = true)
    @Qualifier("businessUserDetailsService")
    public static class BusinessUserDetailsService implements UserDetailsService {
        private final BusinessUserRepository businessUserRepository;

        @Override
        public UserDetails loadUserByUsername(String email) {
            BusinessUser user = businessUserRepository.findByUserInfoEmail(email)
                    .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
            return new UserPrincipal.BusinessUserPrincipal
                    .BusinessUserPrincipalBuilder()
                    .user(user)
                    .build();
        }
    }
}
