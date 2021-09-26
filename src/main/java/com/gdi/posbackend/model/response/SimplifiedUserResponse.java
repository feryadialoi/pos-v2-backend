package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/23/2021 10:50 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimplifiedUserResponse {
    private String id;
    private String name;
}
