package com.codingshuttle.razorpayclone.merchant.controller;

import com.codingshuttle.razorpayclone.merchant.dto.MerchantSignUpResponse;
import com.codingshuttle.razorpayclone.merchant.dto.MerchantSignupRequest;
import com.codingshuttle.razorpayclone.merchant.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {

    AuthService authService;

    @PostMapping
    public ResponseEntity<MerchantSignUpResponse> signup(MerchantSignupRequest signupRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.signup(signupRequest));
    }
}
