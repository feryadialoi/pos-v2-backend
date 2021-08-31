package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.BaseController;
import com.gdi.posbackend.model.request.LoginRequest;
import com.gdi.posbackend.model.request.RefreshTokenRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.LoginResponse;
import com.gdi.posbackend.model.response.RefreshTokenResponse;
import com.gdi.posbackend.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 8/4/2021 9:28 PM
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController extends BaseController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest loginRequest) {
        return response("login success", authService.login(loginRequest));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<ApiResponse<RefreshTokenResponse>> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return response("refresh token success", authService.refreshToken(refreshTokenRequest));
    }

}
