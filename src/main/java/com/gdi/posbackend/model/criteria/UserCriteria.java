package com.gdi.posbackend.model.criteria;

import lombok.Data;
import lombok.Value;

/**
 * @author Feryadialoi
 * @date 9/14/2021 10:28 AM
 */
@Data
public class UserCriteria {
    private String name;
    private String username;
    private String email;
    private String phone;
}
