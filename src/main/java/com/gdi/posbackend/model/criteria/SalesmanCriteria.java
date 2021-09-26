package com.gdi.posbackend.model.criteria;

import lombok.Data;
import lombok.Value;

/**
 * @author Feryadialoi
 * @date 9/14/2021 4:08 PM
 */
@Data
public class SalesmanCriteria {
    private String name;
    private String address;
    private String phone;
    private String companyName;
    private String nationalIdentificationNumber;
}
