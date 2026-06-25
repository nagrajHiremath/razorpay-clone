package com.codingshuttle.razorpayclone.payment.adapter.paymentAdaperImpl;

import com.codingshuttle.razorpayclone.payment.adapter.PaymentAdapter;
import com.codingshuttle.razorpayclone.payment.dto.PayRequest;
import com.codingshuttle.razorpayclone.payment.dto.PaymentResult;

public class NetBankingAdapter implements PaymentAdapter {
    @Override
    public PaymentResult initiate(PayRequest payRequest) {
        return null;
    }
}
