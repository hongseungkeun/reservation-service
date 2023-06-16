package com.numble.reservation.domain.user.common.repository;

import com.numble.reservation.domain.user.common.domain.CommonUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommonUserRepository extends JpaRepository<CommonUser, Long> {
    Optional<CommonUser> findByEmail(String email);
}
