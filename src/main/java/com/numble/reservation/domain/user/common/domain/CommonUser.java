package com.numble.reservation.domain.user.common.domain;

import com.numble.reservation.domain.user.entity.UserInfo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Embedded
    private UserInfo userInfo;

    @Builder
    public CommonUser(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
