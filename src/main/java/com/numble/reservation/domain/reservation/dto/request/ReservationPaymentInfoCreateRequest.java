package com.numble.reservation.domain.reservation.dto.request;

public record ReservationPaymentInfoCreateRequest(
        String paymentMethod,
        String cardNumber,
        String cardExpiration,
        String cardCVV
) {
}
