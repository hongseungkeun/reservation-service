package com.numble.reservation.domain.user.domain;

import com.numble.reservation.domain.user.data.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String businessLicense;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role type;

    @Builder
    public User(Long userId,
                String name,
                String email,
                String password,
                String businessLicense,
                Role type) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.businessLicense = businessLicense;
        this.type = type;
    }
}
