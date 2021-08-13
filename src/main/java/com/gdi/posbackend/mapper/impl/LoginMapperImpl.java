package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.auth.User;
import com.gdi.posbackend.mapper.LoginMapper;
import com.gdi.posbackend.mapper.UserMapper;
import com.gdi.posbackend.model.response.LoginResponse;
import com.gdi.posbackend.security.ApplicationUserDetails;
import com.gdi.posbackend.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Feryadialoi
 * @date 8/4/2021 10:50 PM
 */
@Component
@AllArgsConstructor
public class LoginMapperImpl implements LoginMapper {

    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;

    @Override
    public LoginResponse mapAuthenticationToLoginResponse(Authentication authentication, User user) {

        String subject = authentication.getName();
        Long userId = ((ApplicationUserDetails) authentication.getPrincipal()).getId();
        String tokenId = UUID.randomUUID().toString();
        String accessToken = jwtUtil.generateAccessToken(userId, subject, tokenId);
        String refreshToken = jwtUtil.generateRefreshToken(tokenId);

        return LoginResponse.builder()
                .refreshToken(refreshToken)
                .accessToken(accessToken)
                .user(userMapper.mapUserToUserResponse(user))
                .userId(userId)
                .build();


    }
}
