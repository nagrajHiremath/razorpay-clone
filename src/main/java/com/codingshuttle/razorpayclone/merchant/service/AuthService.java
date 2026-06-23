package com.codingshuttle.razorpayclone.merchant.service;

import com.codingshuttle.razorpayclone.merchant.dto.MerchantSignUpResponse;
import com.codingshuttle.razorpayclone.merchant.dto.MerchantSignupRequest;

public interface AuthService {
    MerchantSignUpResponse signup(MerchantSignupRequest merchantSignupRequest);
}
