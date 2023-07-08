package com.numble.reservation.global.security;

import com.numble.reservation.domain.user.business.domain.BusinessUser;
import com.numble.reservation.domain.user.common.domain.CommonUser;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserPrincipal {
    @Builder(access = AccessLevel.PUBLIC)
    public record CommonUserPrincipal(CommonUser user) implements UserDetails {
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of(new SimpleGrantedAuthority(user.getUserInfo().getType().toString()));
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
    }

    @Builder(access = AccessLevel.PUBLIC)
    public record BusinessUserPrincipal(BusinessUser user) implements UserDetails {
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of(new SimpleGrantedAuthority(user.getUserInfo().getType().toString()));
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
    }
}
