package com.numble.reservation.domain.user.business.domain;

import com.numble.reservation.domain.user.entity.UserInfo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BusinessUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Embedded
    private UserInfo userInfo;
    @Column(nullable = false, length = 12)
    private String businessLicense;

    @Builder
    public BusinessUser(UserInfo userInfo,
                        String businessLicense) {
        this.userInfo = userInfo;
        this.businessLicense = businessLicense;
    }
}
