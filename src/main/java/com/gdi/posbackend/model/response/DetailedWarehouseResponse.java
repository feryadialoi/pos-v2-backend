package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Feryadialoi
 * @date 8/4/2021 10:03 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailedWarehouseResponse {
    private String id;
    private String name;
    private String address;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private LocalDateTime deletedDate;
}
