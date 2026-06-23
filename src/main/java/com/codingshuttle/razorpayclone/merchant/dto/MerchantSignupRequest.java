package com.codingshuttle.razorpayclone.merchant.dto;

import com.codingshuttle.razorpayclone.common.enums.MerchantStatus;

public record MerchantSignupRequest(
        String name,
        String businessName,
        String email,
        String gstId,
        String panId
) {
}
