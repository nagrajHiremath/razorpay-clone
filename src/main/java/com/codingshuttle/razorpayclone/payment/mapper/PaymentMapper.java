package com.codingshuttle.razorpayclone.payment.mapper;

import com.codingshuttle.razorpayclone.payment.dto.PayRequest;
import com.codingshuttle.razorpayclone.payment.dto.PaymentRequest;
import com.codingshuttle.razorpayclone.payment.dto.PaymentResponse;
import com.codingshuttle.razorpayclone.payment.entity.Payment;
import org.mapstruct.Mapper;
import org.springframework.http.ResponseEntity;

@Mapper
public interface PaymentMapper {
    PayRequest toPayRequest(PaymentRequest paymentRequest);

    ResponseEntity<PaymentResponse> toPaymentResponse(Payment payment);
}
