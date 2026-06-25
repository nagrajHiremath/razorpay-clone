package com.codingshuttle.razorpayclone.payment.service.impl;

import com.codingshuttle.razorpayclone.common.enums.OrderStatus;
import com.codingshuttle.razorpayclone.common.enums.PaymentStatus;
import com.codingshuttle.razorpayclone.payment.adapter.PaymentGatewayRouter;
import com.codingshuttle.razorpayclone.payment.dto.PayRequest;
import com.codingshuttle.razorpayclone.payment.dto.PaymentRequest;
import com.codingshuttle.razorpayclone.payment.dto.PaymentResponse;
import com.codingshuttle.razorpayclone.payment.dto.PaymentResult;
import com.codingshuttle.razorpayclone.payment.entity.OrderRecord;
import com.codingshuttle.razorpayclone.payment.entity.Payment;
import com.codingshuttle.razorpayclone.payment.mapper.PaymentMapper;
import com.codingshuttle.razorpayclone.payment.repository.OrderRepository;
import com.codingshuttle.razorpayclone.payment.repository.PaymentRepository;
import com.codingshuttle.razorpayclone.payment.service.PaymentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PaymentServiceImpl implements PaymentService {

    PaymentRepository paymentRepository;
    OrderRepository orderRepository;
    PaymentMapper paymentMapper;
    PaymentGatewayRouter paymentGatewayRouter;

    @Override
    public ResponseEntity<PaymentResponse> initiate(UUID merchantId, PaymentRequest paymentRequest) {

        OrderRecord order = orderRepository.findByIdAndMerchantId(paymentRequest.orderId(), merchantId);

        order.setAttempts(order.getAttempts()+1);
        order.setStatus(OrderStatus.ATTEMPTED);

        orderRepository.save(order);

        Payment payment = Payment.builder()
                .status(PaymentStatus.CREATED)
                .orderRecord(order)
                .merchantId(merchantId)
                .method(paymentRequest.paymentMethod())
                .methodDetails(paymentRequest.methodDetails())
                .build();

        paymentRepository.save(payment);

        PayRequest payRequest = paymentMapper.toPayRequest(paymentRequest);

        PaymentResult result = paymentGatewayRouter.initiate(payRequest);

        switch (result){
            case PaymentResult.Pending pending -> payment.setProcessorRef(pending.ref());

            case PaymentResult.Failure failure -> {
                payment.setStatus(PaymentStatus.FAILED);
                payment.setErrorMessage(failure.message());
            }
        }

        paymentRepository.save(payment);

        return paymentMapper.toPaymentResponse(payment);

    }
}
