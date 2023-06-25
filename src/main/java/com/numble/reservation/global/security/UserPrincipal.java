package com.numble.reservation.global.security;

import com.numble.reservation.domain.user.business.domain.BusinessUser;
import com.numble.reservation.domain.user.common.domain.CommonUser;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserPrincipal {
    public static class CommonUserPrincipal implements UserDetails {
        private final CommonUser user;

        @Builder
        public CommonUserPrincipal(CommonUser user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.emptyList();
        }

        @Override
        public String getPassword() {
            return user.getUserInfo().getPassword();
        }

        @Override
        public String getUsername() {
            return user.getUserInfo().getName();
        }

        @Override
        public boolean isAccountNonExpired() {
            return false;
        }

        @Override
        public boolean isAccountNonLocked() {
            return false;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return false;
        }

        @Override
        public boolean isEnabled() {
            return false;
        }

        public CommonUser getUser(){
            return user;
        }
    }

    public static class BusinessUserPrincipal implements UserDetails {
        private final BusinessUser user;

        @Builder
        public BusinessUserPrincipal(BusinessUser user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.emptyList();
        }

        @Override
        public String getPassword() {
            return user.getUserInfo().getPassword();
        }

        @Override
        public String getUsername() {
            return user.getUserInfo().getName();
        }

        @Override
        public boolean isAccountNonExpired() {
            return false;
        }

        @Override
        public boolean isAccountNonLocked() {
            return false;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return false;
        }

        @Override
        public boolean isEnabled() {
            return false;
        }

        public BusinessUser getUser(){
            return user;
        }
    }
}
