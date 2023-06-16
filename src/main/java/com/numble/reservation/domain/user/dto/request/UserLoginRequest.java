package com.numble.reservation.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserLoginRequest(
        @NotBlank
        @Size(max = 30)
        String email,
        @NotBlank
        @Size(max = 30)
        String password
) {
}
