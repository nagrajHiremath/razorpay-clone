package com.codingshuttle.razorpayclone.payment.service;

import com.codingshuttle.razorpayclone.payment.dto.PaymentRequest;
import com.codingshuttle.razorpayclone.payment.dto.PaymentResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface PaymentService {
    ResponseEntity<PaymentResponse> initiate(UUID merchantId, PaymentRequest paymentRequest);
}
