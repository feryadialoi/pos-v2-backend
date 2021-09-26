package com.gdi.posbackend.service.impl;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.gdi.posbackend.entity.auth.User;
import com.gdi.posbackend.exception.RefreshTokenExpiredException;
import com.gdi.posbackend.exception.TokenIdNotMatchException;
import com.gdi.posbackend.mapper.LoginMapper;
import com.gdi.posbackend.mapper.RefreshTokenMapper;
import com.gdi.posbackend.model.request.LoginRequest;
import com.gdi.posbackend.model.request.RefreshTokenRequest;
import com.gdi.posbackend.model.response.LoginResponse;
import com.gdi.posbackend.model.response.RefreshTokenResponse;
import com.gdi.posbackend.repository.UserRepository;
import com.gdi.posbackend.security.JwtUtil;
import com.gdi.posbackend.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Feryadialoi
 * @date 8/4/2021 9:52 PM
 */
@Slf4j
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final LoginMapper loginMapper;
    private final RefreshTokenMapper refreshTokenMapper;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword(),
                new ArrayList<>());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        log.info(String.valueOf(authentication));

        User user = userRepository.findUserByUsername(loginRequest.getUsername());

        return loginMapper.mapAuthenticationToLoginResponse(authentication, user);
    }

    @Override
    public RefreshTokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String accessToken = refreshTokenRequest.getAccessToken();
        String refreshToken = refreshTokenRequest.getRefreshToken();

        try {
            jwtUtil.verifyToken(refreshToken);
        } catch (TokenExpiredException exception) {
            throw new RefreshTokenExpiredException("refresh token expired, please re-login");
        }

        if (!isTokenIdMatch(accessToken, refreshToken)) throw new TokenIdNotMatchException("token id not match");

        String generateAccessToken = jwtUtil.generateAccessToken(accessToken);

        log.info("generateAccessToken = {}", generateAccessToken);
        return refreshTokenMapper.mapTokenToRefreshTokenResponse(generateAccessToken);
    }

    private Boolean isTokenIdMatch(String accessToken, String refreshToken) {
        return jwtUtil.getTokenId(accessToken).equals(jwtUtil.getTokenId(refreshToken));
    }
}
