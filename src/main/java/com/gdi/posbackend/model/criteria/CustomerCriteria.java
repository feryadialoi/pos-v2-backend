package com.gdi.posbackend.model.criteria;

import lombok.Data;
import lombok.Value;

/**
 * @author Feryadialoi
 * @date 9/14/2021 12:15 PM
 */
@Data
public class CustomerCriteria {
    private String name;
    private String nationalIdentificationNumber;
    private String address;
    private String phone;
    private String phone2;
    private String description;
}
