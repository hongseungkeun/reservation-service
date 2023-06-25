package com.numble.reservation.domain.user.entity;

import com.numble.reservation.domain.user.data.Role;
import com.numble.reservation.domain.user.exception.PasswordMismatchException;
import com.numble.reservation.global.exception.error.ErrorCode;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfo {
    @Column(nullable = false, length = 20)
    private String name;
    @Column(unique = true, nullable = false, length = 30)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role type;

    @Builder
    public UserInfo(String name, String email, String password, Role type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public void isPossibleLogin(PasswordEncoder passwordEncoder, String password){
        if (!passwordEncoder.matches(password, this.password)) {
            throw new PasswordMismatchException(ErrorCode.PASSWORD_MISMATCH);
        }
    }
}
