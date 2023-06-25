package com.numble.reservation.global.security;

import com.numble.reservation.domain.user.data.Role;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface JwtTokenProvider {
    String createToken(String userEmail, Role role);
    Authentication getAuthentication(String token);
    String getUserId(String token);
    boolean validateToken(String jwtToken);

    default String resolveToken(HttpServletRequest request) {
        return request.getHeader("accessToken");
    }
}
