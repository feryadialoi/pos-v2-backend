package com.gdi.posbackend.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Feryadialoi
 * @date 8/4/2021 9:55 PM
 */
@Data
public class RefreshTokenRequest {

    @NotBlank
    private String accessToken;

    @NotBlank
    private String refreshToken;
}
