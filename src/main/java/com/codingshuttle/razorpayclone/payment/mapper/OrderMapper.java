package com.codingshuttle.razorpayclone.payment.mapper;

import com.codingshuttle.razorpayclone.payment.dto.OrderCreateRequest;
import com.codingshuttle.razorpayclone.payment.dto.OrderResponse;
import com.codingshuttle.razorpayclone.payment.entity.OrderRecord;

public interface OrderMapper {
    OrderRecord toOrderRecord(OrderCreateRequest orderCreateRequest);

    OrderResponse toOrderResponse(OrderRecord orderRecord);
}
