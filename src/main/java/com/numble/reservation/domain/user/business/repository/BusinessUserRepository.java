package com.numble.reservation.domain.user.business.repository;

import com.numble.reservation.domain.user.business.domain.BusinessUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessUserRepository extends JpaRepository<BusinessUser, Long> {
    Optional<BusinessUser> findByEmail(String email);
}
