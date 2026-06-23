package com.codingshuttle.razorpayclone.payment.service.impl;

import com.codingshuttle.razorpayclone.payment.dto.OrderCreateRequest;
import com.codingshuttle.razorpayclone.payment.dto.OrderResponse;
import com.codingshuttle.razorpayclone.payment.entity.OrderRecord;
import com.codingshuttle.razorpayclone.payment.mapper.OrderMapper;
import com.codingshuttle.razorpayclone.payment.repository.OrderRepository;
import com.codingshuttle.razorpayclone.payment.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    OrderMapper orderMapper;

    @Override
    public OrderResponse createOrder(OrderCreateRequest orderCreateRequest) {
        OrderRecord orderRecord = orderMapper.toOrderRecord(orderCreateRequest);

        orderRepository.save(orderRecord);

        return orderMapper.toOrderResponse(orderRecord);
    }
}
