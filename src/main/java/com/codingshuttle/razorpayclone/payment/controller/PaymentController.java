package com.codingshuttle.razorpayclone.payment.controller;

import com.codingshuttle.razorpayclone.payment.dto.PaymentRequest;
import com.codingshuttle.razorpayclone.payment.dto.PaymentResponse;
import com.codingshuttle.razorpayclone.payment.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponse> initiate(UUID merchantId, PaymentRequest paymentRequest){
        return paymentService.initiate(merchantId, paymentRequest);
    }
}
