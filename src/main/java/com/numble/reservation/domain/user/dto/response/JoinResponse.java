package com.numble.reservation.domain.user.dto.response;

import com.numble.reservation.domain.user.data.Role;
import com.numble.reservation.domain.user.dto.request.JoinRequest;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record JoinResponse(
        String name,
        String email,
        String password,
        String businessLicense,
        String type
) {
    public static JoinResponse toJoinResponse(JoinRequest request){
        return JoinResponse.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .businessLicense(request.businessLicense())
                .type(request.type().getRole())
                .build();
    }
    public UserJoinResponse toUserJoinResponse(){
        return UserJoinResponse.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .build();
    }

    public BusinessJoinResponse toBusinessJoinResponse(){
        return BusinessJoinResponse.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .businessLicense(this.businessLicense)
                .type(this.type)
                .build();
    }
}
