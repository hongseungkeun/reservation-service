package com.numble.reservation.domain.user.entity;

import com.numble.reservation.domain.user.data.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfo {
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 30)
    private String email;
    @Column(nullable = false, length = 30)
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
}
