package com.codingshuttle.razorpayclone.payment.service;

import com.codingshuttle.razorpayclone.payment.dto.OrderCreateRequest;
import com.codingshuttle.razorpayclone.payment.dto.OrderResponse;

public interface OrderService {
    OrderResponse createOrder(OrderCreateRequest orderCreateRequest);
}
