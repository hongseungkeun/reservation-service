package com.numble.reservation.global.config;

import com.numble.reservation.global.filter.JwtAuthenticationFilter;
import com.numble.reservation.global.security.JwtTokenProvider;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityConfig{

    @Configuration
    @EnableWebSecurity
    @RequiredArgsConstructor
    public static class CommonSecurityConfig{
        @Qualifier("commonJwtTokenProvider")
        private final JwtTokenProvider jwtTokenProvider;

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        protected SecurityFilterChain commonFilterChain(HttpSecurity http) throws Exception {
            http
                    .httpBasic(withDefaults())
                    .csrf(AbstractHttpConfigurer::disable)
                    .formLogin(AbstractHttpConfigurer::disable)
                    .sessionManagement((s) -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests((request) -> request
                            .requestMatchers("/reservations").hasRole("COMMON")
                            .requestMatchers("/venues").denyAll()
                            .requestMatchers(HttpMethod.POST,"/performances").denyAll()
                            .anyRequest()
                            .permitAll()
                    )
                    .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                            UsernamePasswordAuthenticationFilter.class);
            return http.build();
        }
    }

    @Configuration
    @EnableWebSecurity
    @RequiredArgsConstructor
    public static class BusinessSecurityConfig{
        @Qualifier("businessJwtTokenProvider")
        private final JwtTokenProvider jwtTokenProvider;

        @Bean
        protected SecurityFilterChain businessFilterChain(HttpSecurity http) throws Exception {
            http
                    .httpBasic(withDefaults())
                    .csrf(AbstractHttpConfigurer::disable)
                    .formLogin(AbstractHttpConfigurer::disable)
                    .sessionManagement((s) -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests((request) -> request
                            .requestMatchers("/venues").hasRole("VENUE_ADMIN")
                            .requestMatchers(HttpMethod.POST,"/performances").hasRole("PERFORMANCE_ADMIN")
                            .requestMatchers("/reservations").denyAll()
                            .anyRequest()
                            .permitAll()
                    )
                    .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                            UsernamePasswordAuthenticationFilter.class);
            return http.build();
        }
    }
}
