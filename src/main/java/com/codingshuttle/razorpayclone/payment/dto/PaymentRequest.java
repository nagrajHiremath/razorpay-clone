package com.codingshuttle.razorpayclone.payment.dto;

import com.codingshuttle.razorpayclone.common.enums.PaymentMethod;

import java.util.Map;
import java.util.UUID;

public record PaymentRequest(
        UUID orderId,
        PaymentMethod paymentMethod,
        Map<String, Object> methodDetails

) {
}
