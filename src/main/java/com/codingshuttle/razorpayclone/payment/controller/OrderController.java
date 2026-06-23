package com.codingshuttle.razorpayclone.payment.controller;

import com.codingshuttle.razorpayclone.payment.dto.OrderCreateRequest;
import com.codingshuttle.razorpayclone.payment.dto.OrderResponse;
import com.codingshuttle.razorpayclone.payment.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {

    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(OrderCreateRequest orderCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(orderCreateRequest));
    }
}
