package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.mapper.RefreshTokenMapper;
import com.gdi.posbackend.model.response.RefreshTokenResponse;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/5/2021 12:25 AM
 */
@Component
public class RefreshTokenMapperImpl implements RefreshTokenMapper {

    @Override
    public RefreshTokenResponse mapTokenToRefreshTokenResponse(String token) {
        return RefreshTokenResponse.builder()
                .accessToken(token)
                .build();
    }

}
