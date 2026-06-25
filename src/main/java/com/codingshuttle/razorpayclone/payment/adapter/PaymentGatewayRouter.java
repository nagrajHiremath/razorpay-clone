package com.codingshuttle.razorpayclone.payment.adapter;

import com.codingshuttle.razorpayclone.common.enums.PaymentMethod;
import com.codingshuttle.razorpayclone.payment.dto.PayRequest;
import com.codingshuttle.razorpayclone.payment.dto.PaymentResult;

import java.util.Map;

public class PaymentGatewayRouter {

    Map<PaymentMethod, PaymentAdapter> paymentAdaperMap;

    public PaymentResult initiate(PayRequest payRequest){
        PaymentAdapter paymentAdapter = paymentAdaperMap.get(payRequest.paymentMethod());
        return paymentAdapter.initiate(payRequest);
    }
}
