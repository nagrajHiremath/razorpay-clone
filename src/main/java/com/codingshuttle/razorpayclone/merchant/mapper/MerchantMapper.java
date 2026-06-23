package com.codingshuttle.razorpayclone.merchant.mapper;

import com.codingshuttle.razorpayclone.merchant.dto.MerchantSignupRequest;
import com.codingshuttle.razorpayclone.merchant.entity.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MerchantMapper {
    Merchant toMerchant(MerchantSignupRequest merchantSignupRequest);
}
