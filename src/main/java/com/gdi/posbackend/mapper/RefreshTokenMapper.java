package com.gdi.posbackend.mapper;

import com.gdi.posbackend.model.response.RefreshTokenResponse;

/**
 * @author Feryadialoi
 * @date 8/5/2021 12:24 AM
 */
public interface RefreshTokenMapper {
    RefreshTokenResponse mapTokenToRefreshTokenResponse(String token);
}
