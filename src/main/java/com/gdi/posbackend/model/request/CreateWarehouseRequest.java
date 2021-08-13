package com.gdi.posbackend.model.request;

import lombok.Data;

/**
 * @author Feryadialoi
 * @date 8/4/2021 10:05 PM
 */
@Data
public class CreateWarehouseRequest {
    private String name;
    private String address;
}
