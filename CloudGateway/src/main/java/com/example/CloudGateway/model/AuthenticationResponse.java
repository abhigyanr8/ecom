package com.example.CloudGateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationResponse
{
    private String userId;
    private String accessToken;
    private String refreshToken;
    private long expiresat;
    private Collection<String> authorityList;
}
