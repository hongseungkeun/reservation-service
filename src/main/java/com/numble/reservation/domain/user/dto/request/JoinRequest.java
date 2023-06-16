package com.numble.reservation.domain.user.dto.request;

import com.numble.reservation.domain.user.business.domain.BusinessUser;
import com.numble.reservation.domain.user.entity.UserInfo;
import com.numble.reservation.domain.user.data.Role;
import com.numble.reservation.domain.user.common.domain.CommonUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record JoinRequest(
        @NotBlank
        @Size(max = 20)
        String name,
        @NotBlank
        String email,
        @NotBlank
        @Size(max = 30)
        String password,
        @Size(max = 12)
        String businessLicense,
        @NotNull Role type
) {
    public CommonUser toUserJoin() {
        return CommonUser.builder()
                .userInfo(UserInfo.builder()
                        .name(this.name)
                        .email(this.email)
                        .password(this.password)
                        .type(this.type)
                        .build())
                .build();
    }

    public BusinessUser toBusinessJoin() {
        return BusinessUser.builder()
                .userInfo(UserInfo.builder()
                        .name(this.name)
                        .email(this.email)
                        .password(this.password)
                        .type(this.type)
                        .build())
                .businessLicense(this.businessLicense)
                .build();
    }
}
