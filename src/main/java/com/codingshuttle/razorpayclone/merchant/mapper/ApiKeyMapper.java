package com.codingshuttle.razorpayclone.merchant.mapper;

import com.codingshuttle.razorpayclone.merchant.dto.ApiKeyCreateResponse;
import com.codingshuttle.razorpayclone.merchant.dto.ApiKeyResponse;
import com.codingshuttle.razorpayclone.merchant.entity.ApiKey;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApiKeyMapper {

  ApiKeyResponse toApiKeyResponse(ApiKey apiKey);

  List<ApiKeyResponse> toApiResponseList(List<ApiKey> apiKeyList);

  ApiKeyCreateResponse toApikeyCreateResponse(ApiKey apiKey);
}
