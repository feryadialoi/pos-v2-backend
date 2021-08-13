package com.gdi.posbackend.service;

import com.gdi.posbackend.model.request.LoginRequest;
import com.gdi.posbackend.model.request.RefreshTokenRequest;
import com.gdi.posbackend.model.response.LoginResponse;
import com.gdi.posbackend.model.response.RefreshTokenResponse;

/**
 * @author Feryadialoi
 * @date 8/4/2021 9:52 PM
 */
public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    RefreshTokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
