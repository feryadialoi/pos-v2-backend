package com.gdi.posbackend.model.request;

import lombok.Data;

/**
 * @author Feryadialoi
 * @date 8/4/2021 9:55 PM
 */
@Data
public class RefreshTokenRequest {
    private String accessToken;
    private String refreshToken;
}
