package com.numble.reservation.domain.user.dto.request;

import com.numble.reservation.domain.user.business.domain.BusinessUser;
import com.numble.reservation.domain.user.entity.UserInfo;
import com.numble.reservation.domain.user.data.Role;
import com.numble.reservation.domain.user.common.domain.CommonUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.password.PasswordEncoder;

public record UserJoinRequest(
        @NotBlank
        @Size(max = 20)
        String name,
        @NotBlank
        @Size(max = 30)
        String email,
        @NotBlank
        @Size(max = 30)
        String password,
        @Size(max = 12)
        String businessLicense,
        @NotNull Role type
) {
    public CommonUser toCommonUser(PasswordEncoder passwordEncoder) {
        return CommonUser.builder()
                .userInfo(UserInfo.builder()
                        .name(this.name)
                        .email(this.email)
                        .password(passwordEncoder.encode(this.password))
                        .type(this.type)
                        .build())
                .build();
    }

    public BusinessUser toBusinessUser(PasswordEncoder passwordEncoder) {
        return BusinessUser.builder()
                .userInfo(UserInfo.builder()
                        .name(this.name)
                        .email(this.email)
                        .password(passwordEncoder.encode(this.password))
                        .type(this.type)
                        .build())
                .businessLicense(this.businessLicense)
                .build();
    }
}
