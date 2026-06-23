package com.codingshuttle.razorpayclone.merchant.service.impl;

import com.codingshuttle.razorpayclone.common.enums.UserRole;
import com.codingshuttle.razorpayclone.merchant.dto.MerchantSignUpResponse;
import com.codingshuttle.razorpayclone.merchant.dto.MerchantSignupRequest;
import com.codingshuttle.razorpayclone.merchant.entity.AppUser;
import com.codingshuttle.razorpayclone.merchant.entity.Merchant;
import com.codingshuttle.razorpayclone.merchant.mapper.MerchantMapper;
import com.codingshuttle.razorpayclone.merchant.repository.AppUserRepository;
import com.codingshuttle.razorpayclone.merchant.repository.MerchantRepository;
import com.codingshuttle.razorpayclone.merchant.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    MerchantRepository merchantRepository;
    AppUserRepository appUserRepository;
    MerchantMapper merchantMapper;

    @Override
    public MerchantSignUpResponse signup(MerchantSignupRequest merchantSignupRequest) {

        if(merchantRepository.findByEmail(merchantSignupRequest.email()))
            throw new RuntimeException("already account exist by this email, try sign in");

        Merchant merchant = merchantMapper.toMerchant(merchantSignupRequest);

        merchantRepository.save(merchant);

        AppUser appUser = AppUser.builder()
                .email(merchantSignupRequest.email())
                .merchant(merchant)
                .role(UserRole.OWNER)
                .build();

        appUserRepository.save(appUser);

        return new MerchantSignUpResponse("token");
    }
}
