package com.numble.reservation.domain.user.dto.request;

import com.numble.reservation.domain.user.data.Role;
import com.numble.reservation.domain.user.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JoinRequest(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String password,
        String businessLicense,
        @NotNull Role type
) {
    public User toUserJoin() {
        return User.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .type(this.type)
                .build();
    }

    public User toBusinessJoin() {
        return User.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .businessLicense(this.businessLicense)
                .type(this.type)
                .build();
    }
}
