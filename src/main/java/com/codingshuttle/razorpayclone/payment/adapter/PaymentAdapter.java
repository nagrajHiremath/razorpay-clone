package com.codingshuttle.razorpayclone.payment.adapter;

import com.codingshuttle.razorpayclone.payment.dto.PayRequest;
import com.codingshuttle.razorpayclone.payment.dto.PaymentResult;

public interface PaymentAdapter {
    PaymentResult initiate(PayRequest payRequest);
}
