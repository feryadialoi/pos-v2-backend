package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

/**
 * @author Feryadialoi
 * @date 7/25/2021 3:21 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<D, E> {
    private String message;
    private D data;
    private E error;
}
