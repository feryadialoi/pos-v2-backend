package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.auth.User;
import com.gdi.posbackend.model.response.LoginResponse;
import org.springframework.security.core.Authentication;

/**
 * @author Feryadialoi
 * @date 8/4/2021 10:49 PM
 */
public interface LoginMapper {
    LoginResponse mapAuthenticationToLoginResponse(Authentication authentication, User user);
}
