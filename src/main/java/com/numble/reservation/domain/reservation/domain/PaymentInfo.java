package com.numble.reservation.domain.reservation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentInfo {
    @Column(nullable = false)
    private String paymentMethod;
    @Column(nullable = false)
    private String cardNumber;
    @Column(nullable = false)
    private String cardExpiration;
    @Column(nullable = false)
    private String cardCVV;

    @Builder
    public PaymentInfo(String paymentMethod,
                       String cardNumber,
                       String cardExpiration,
                       String cardCVV) {
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.cardExpiration = cardExpiration;
        this.cardCVV = cardCVV;
    }
}
